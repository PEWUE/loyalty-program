package com.PEWUE.loyalty_program.mapper;

import com.PEWUE.loyalty_program.dto.LoyaltyProgramCreateDTO;
import com.PEWUE.loyalty_program.dto.LoyaltyProgramDTO;
import com.PEWUE.loyalty_program.dto.LoyaltyProgramUpdateDTO;
import com.PEWUE.loyalty_program.model.LoyaltyProgram;
import com.PEWUE.loyalty_program.model.Period;
import com.PEWUE.loyalty_program.util.CycleAvoidingMappingContext;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;


@Mapper(componentModel = "spring")
public interface LoyaltyProgramMapper {
    @Mapping(source = "period.startDate", target = "startDate")
    @Mapping(source = "period.endDate", target = "endDate")
    LoyaltyProgramDTO toDto(LoyaltyProgram loyaltyProgram, @Context CycleAvoidingMappingContext context);

    @Mapping(target = "period", expression = "java(toPeriod(dto.getStartDate(), dto.getEndDate()))")
    LoyaltyProgram toEntity(LoyaltyProgramDTO dto, @Context CycleAvoidingMappingContext context);

    @Mapping(target = "period", expression = "java(toPeriod(dto.getStartDate(), dto.getEndDate()))")
    LoyaltyProgram toEntity(LoyaltyProgramCreateDTO dto, @Context CycleAvoidingMappingContext context);

    @Mapping(target = "period", expression = "java(toPeriod(dto.getStartDate(), dto.getEndDate()))")
    LoyaltyProgram toEntity(LoyaltyProgramUpdateDTO dto, @Context CycleAvoidingMappingContext context);

    default Period toPeriod(LocalDateTime startDate, LocalDateTime endDate) {
        if (startDate == null && endDate == null) {
            return null;
        }
        return Period.builder()
                .startDate(startDate)
                .endDate(endDate)
                .build();
     }
}
