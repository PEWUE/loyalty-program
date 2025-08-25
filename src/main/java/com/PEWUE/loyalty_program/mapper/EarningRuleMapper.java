package com.PEWUE.loyalty_program.mapper;

import com.PEWUE.loyalty_program.dto.EarningRuleCreateDTO;
import com.PEWUE.loyalty_program.dto.EarningRuleDTO;
import com.PEWUE.loyalty_program.dto.EarningRuleUpdateDTO;
import com.PEWUE.loyalty_program.enums.EarningEventType;
import com.PEWUE.loyalty_program.model.EarningRule;
import com.PEWUE.loyalty_program.model.Period;
import com.PEWUE.loyalty_program.util.CycleAvoidingMappingContext;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring", uses = LoyaltyProgramMapper.class)
public interface EarningRuleMapper {
    @Mapping(target = "eventType", expression = "java(rule.getEventType().name())")
    @Mapping(source = "period.startDate", target = "startDate")
    @Mapping(source = "period.endDate", target = "endDate")
    EarningRuleDTO toDto(EarningRule rule, @Context CycleAvoidingMappingContext context);

    @Mapping(target = "period", expression = "java(toPeriod(dto.getStartDate(), dto.getEndDate()))")
    @Mapping(target = "eventType", expression = "java(stringToEventType(dto.getEventType()))")
    EarningRule toEntity(EarningRuleDTO dto, @Context CycleAvoidingMappingContext context);

    @Mapping(target = "period", expression = "java(toPeriod(dto.getStartDate(), dto.getEndDate()))")
    @Mapping(target = "eventType", expression = "java(stringToEventType(dto.getEventType()))")
    EarningRule toEntity(EarningRuleCreateDTO dto, @Context CycleAvoidingMappingContext context);

    @Mapping(target = "period", expression = "java(toPeriod(dto.getStartDate(), dto.getEndDate()))")
    EarningRule toEntity(EarningRuleUpdateDTO dto, @Context CycleAvoidingMappingContext context);

    default Period toPeriod(LocalDateTime startDate, LocalDateTime endDate) {
        if (startDate == null && endDate == null) {
            return null;
        }
        return Period.builder()
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }

    default EarningEventType stringToEventType(String eventType) {
        if (eventType == null) {
            return null;
        }
        try {
            return EarningEventType.valueOf(eventType);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
