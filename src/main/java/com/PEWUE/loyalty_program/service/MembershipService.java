package com.PEWUE.loyalty_program.service;

import com.PEWUE.loyalty_program.dto.UserDTO;
import com.PEWUE.loyalty_program.exception.ProgramNotFoundException;
import com.PEWUE.loyalty_program.exception.UserAlreadyMemberOfProgramException;
import com.PEWUE.loyalty_program.exception.UserNotFoundException;
import com.PEWUE.loyalty_program.mapper.MembershipMapper;
import com.PEWUE.loyalty_program.mapper.UserMapper;
import com.PEWUE.loyalty_program.model.LoyaltyProgram;
import com.PEWUE.loyalty_program.model.Membership;
import com.PEWUE.loyalty_program.model.User;
import com.PEWUE.loyalty_program.repository.LoyaltyProgramRepository;
import com.PEWUE.loyalty_program.repository.MembershipRepository;
import com.PEWUE.loyalty_program.repository.UserRepository;
import com.PEWUE.loyalty_program.util.CycleAvoidingMappingContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MembershipService {
    private final MembershipRepository membershipRepository;
    private final UserRepository userRepository;
    private final LoyaltyProgramRepository loyaltyProgramRepository;
    private final UserMapper userMapper;
    private final CycleAvoidingMappingContext context;

    public UserDTO addMembership(Long userId, Long programId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with id: " + userId + " not found"));
        LoyaltyProgram loyaltyProgram = loyaltyProgramRepository.findById(programId)
                .orElseThrow(() -> new ProgramNotFoundException("Program with id: " + programId + " not found"));

        if (isUserAlreadyMemberOfProgram(user, programId)) {
            throw new UserAlreadyMemberOfProgramException("User with id " + userId + " is already member of program with id " + programId);
        }

        Membership membership = Membership.builder()
                .user(user)
                .loyaltyProgram(loyaltyProgram)
                .joinDate(LocalDateTime.now())
                .pointsBalance(0L)
                .transactions(new ArrayList<>())
                .build();

        Membership savedMembership = membershipRepository.save(membership);

        if (user.getMemberships() == null) {
            user.setMemberships(new ArrayList<>());
        }
        user.getMemberships().add(savedMembership);

        if (loyaltyProgram.getMemberships() == null) {
            loyaltyProgram.setMemberships(new ArrayList<>());
        }
        loyaltyProgram.getMemberships().add(savedMembership);

        User updatedUser = userRepository.updateUser(user, user);
        loyaltyProgramRepository.updateProgram(loyaltyProgram, loyaltyProgram);

        return userMapper.toDto(updatedUser, context);
    }

    private boolean isUserAlreadyMemberOfProgram(User user, Long programId) {
        if (CollectionUtils.isEmpty(user.getMemberships())) {
            return false;
        }
        return user.getMemberships().stream()
                .anyMatch(membership -> membership.getLoyaltyProgram().getId().equals(programId));
    }
}
