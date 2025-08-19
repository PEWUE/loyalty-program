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
public class EarningRule {
    private Long id;
    private String name;
    private EarningEventType eventType;
    private Long points;
    private Period period;
    private boolean active;
    private LoyaltyProgram loyaltyProgram;
}
