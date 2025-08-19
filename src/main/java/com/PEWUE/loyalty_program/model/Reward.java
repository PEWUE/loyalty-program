package com.PEWUE.loyalty_program.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reward {
    private Long id;
    private String name;
    private String description;
    private Long pointCost;
    private Period period;
    private boolean active;
    private LoyaltyProgram loyaltyProgram;
    private List<PointsTransaction> transactions;
}
