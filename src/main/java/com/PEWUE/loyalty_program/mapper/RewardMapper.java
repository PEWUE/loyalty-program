package com.PEWUE.loyalty_program.mapper;

import com.PEWUE.loyalty_program.dto.RewardCreateDTO;
import com.PEWUE.loyalty_program.dto.RewardDTO;
import com.PEWUE.loyalty_program.model.Period;
import com.PEWUE.loyalty_program.model.Reward;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring", uses = LoyaltyProgramMapper.class)
public interface RewardMapper {
    @Mapping(source = "period.startDate", target = "startDate")
    @Mapping(source = "period.endDate", target = "endDate")
    RewardDTO toDto(Reward reward);

    @Mapping(target = "period", expression = "java(toPeriod(dto.getStartDate(), dto.getEndDate()))")
    Reward toEntity(RewardDTO dto);

    @Mapping(target = "period", expression = "java(toPeriod(dto.getStartDate(), dto.getEndDate()))")
    Reward toEntity(RewardCreateDTO dto);

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
