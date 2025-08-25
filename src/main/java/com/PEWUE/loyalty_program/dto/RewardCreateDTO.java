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
public class RewardCreateDTO {
    private String name;
    private String description;
    private Long pointCost;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LoyaltyProgramDTO loyaltyProgram;
}
