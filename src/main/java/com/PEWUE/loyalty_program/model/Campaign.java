package com.PEWUE.loyalty_program.model;

import com.PEWUE.loyalty_program.enums.EarningEventType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Campaign {
    private Long id;
    private String name;
    private String description;
    private Period period;
    private Double multiplier;
    private Long extraPoints;
    private EarningEventType eventType;
    private LoyaltyProgram loyaltyProgram;
}
