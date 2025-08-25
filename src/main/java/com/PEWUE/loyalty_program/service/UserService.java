package com.PEWUE.loyalty_program.service;

import com.PEWUE.loyalty_program.dto.UserRegistrationDTO;
import com.PEWUE.loyalty_program.dto.UserUpdateDTO;
import com.PEWUE.loyalty_program.exception.UserAlreadyExistsException;
import com.PEWUE.loyalty_program.exception.UserNotFoundException;
import com.PEWUE.loyalty_program.mapper.UserMapper;
import com.PEWUE.loyalty_program.model.User;
import com.PEWUE.loyalty_program.repository.UserRepository;
import com.PEWUE.loyalty_program.util.CycleAvoidingMappingContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User registerUser(UserRegistrationDTO userRegistrationDTO) {
        CycleAvoidingMappingContext context = new CycleAvoidingMappingContext();
        if (userRegistrationDTO.getFirstName() == null ||
                userRegistrationDTO.getLastName() == null ||
                userRegistrationDTO.getEmail() == null) {
            throw new IllegalArgumentException("Fields should not be null");
        }
        if (userRepository.findByEmail(userRegistrationDTO.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("User with email " + userRegistrationDTO.getEmail() + " already exists");
        }
        User user = userMapper.toEntity(userRegistrationDTO, context);
        user.setRegistrationDate(LocalDateTime.now());
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id: " + id + " not found"));
    }

    public User updateUser(Long id, UserUpdateDTO userUpdateDTO) {
        if (userUpdateDTO.getFirstName() == null ||
                userUpdateDTO.getLastName() == null ||
                userUpdateDTO.getEmail() == null) {
            throw new IllegalArgumentException("Fields should not be null");
        }
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id: " + id + " not found"));

        if (!existingUser.getEmail().equals(userUpdateDTO.getEmail()) &&
                userRepository.findByEmail(userUpdateDTO.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("User with email " + userUpdateDTO.getEmail() + " already exists");
        }

        existingUser.setEmail(userUpdateDTO.getEmail());
        existingUser.setFirstName(userUpdateDTO.getFirstName());
        existingUser.setLastName(userUpdateDTO.getLastName());

        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        if (userRepository.findById(id).isEmpty()) {
            throw new UserNotFoundException("User with id: " + id + " not found");
        }
        userRepository.deleteById(id);
    }
}
