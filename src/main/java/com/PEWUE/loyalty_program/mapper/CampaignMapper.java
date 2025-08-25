package com.PEWUE.loyalty_program.mapper;

import com.PEWUE.loyalty_program.dto.CampaignDTO;
import com.PEWUE.loyalty_program.model.Campaign;
import com.PEWUE.loyalty_program.model.Period;
import com.PEWUE.loyalty_program.util.CycleAvoidingMappingContext;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring", uses = LoyaltyProgramMapper.class)
public interface CampaignMapper {
    @Mapping(source = "period.startDate", target = "startDate")
    @Mapping(source = "period.endDate", target = "endDate")
    @Mapping(target = "eventType", expression = "java(campaign.getEventType().name())")
    CampaignDTO toDto(Campaign campaign, @Context CycleAvoidingMappingContext context);

    @Mapping(target = "period", expression = "java(toPeriod(dto.getStartDate(), dto.getEndDate()))")
    Campaign toEntity(CampaignDTO dto, @Context CycleAvoidingMappingContext context);

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
