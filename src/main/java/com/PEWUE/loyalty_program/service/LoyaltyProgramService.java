package com.PEWUE.loyalty_program.service;

import com.PEWUE.loyalty_program.dto.LoyaltyProgramCreateDTO;
import com.PEWUE.loyalty_program.dto.LoyaltyProgramUpdateDTO;
import com.PEWUE.loyalty_program.exception.LoyaltyProgramCannotBeDeletedException;
import com.PEWUE.loyalty_program.exception.ProgramAlreadyExistsException;
import com.PEWUE.loyalty_program.exception.ProgramNotFoundException;
import com.PEWUE.loyalty_program.mapper.LoyaltyProgramMapper;
import com.PEWUE.loyalty_program.model.LoyaltyProgram;
import com.PEWUE.loyalty_program.model.Period;
import com.PEWUE.loyalty_program.repository.LoyaltyProgramRepository;
import com.PEWUE.loyalty_program.util.CycleAvoidingMappingContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoyaltyProgramService {
    private final LoyaltyProgramRepository loyaltyProgramRepository;
    private final LoyaltyProgramMapper loyaltyProgramMapper;

    public List<LoyaltyProgram> getAllPrograms() {
        return loyaltyProgramRepository.findAll();
    }

    public LoyaltyProgram createProgram(LoyaltyProgramCreateDTO dto) {
        CycleAvoidingMappingContext context = new CycleAvoidingMappingContext();
        if (dto.getName() == null || dto.getStartDate() == null) {
            throw new IllegalArgumentException("Fields should not be null");
        }
        if (dto.getEndDate() != null && dto.getStartDate().isAfter(dto.getEndDate())) {
            throw new IllegalArgumentException("Start date must be before end date");
        }
        if (loyaltyProgramRepository.findByName(dto.getName()).isPresent()) {
            throw new ProgramAlreadyExistsException("Program with name: " + dto.getName() + " already exists");
        }

        LoyaltyProgram loyaltyProgram = loyaltyProgramMapper.toEntity(dto, context);
        return loyaltyProgramRepository.save(loyaltyProgram);
    }

    public LoyaltyProgram getProgramById(Long id) {
        return loyaltyProgramRepository.findById(id)
                .orElseThrow(() -> new ProgramNotFoundException("Program with id: " + id + " not found"));
    }

    public LoyaltyProgram updateProgram(Long id, LoyaltyProgramUpdateDTO dto) {
        if (dto.getStartDate() == null) {
            throw new IllegalArgumentException("Fields should not be null");
        }
        if (dto.getEndDate() != null && dto.getStartDate().isAfter(dto.getEndDate())) {
            throw new IllegalArgumentException("Start date must be before end date");
        }
        LoyaltyProgram existingProgram = loyaltyProgramRepository.findById(id)
                .orElseThrow(() -> new ProgramNotFoundException("Program with id: " + id + " not found"));
        existingProgram.setDescription(dto.getDescription());
        existingProgram.setPeriod(Period.builder().startDate(dto.getStartDate()).endDate(dto.getEndDate()).build());
        return loyaltyProgramRepository.save(existingProgram);
    }

    public void deleteProgram(Long id) {
        LoyaltyProgram existingProgram = loyaltyProgramRepository.findById(id)
                .orElseThrow(() -> new ProgramNotFoundException("Program with id: " + id + " not found"));
        if (!CollectionUtils.isEmpty(existingProgram.getMemberships())) {
            throw new LoyaltyProgramCannotBeDeletedException("Cannot delete loyalty program with active memberships");
        }
        loyaltyProgramRepository.deleteById(id);
    }
}
