package com.PEWUE.loyalty_program.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EarningRuleCreateDTO {
    private String name;
    private String eventType;
    private Long points;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long loyaltyProgramId;
}
