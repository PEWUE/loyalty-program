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
public class LoyaltyProgram {
    private Long id;
    private String name;
    private String description;
    private Period period;
    private List<Membership> memberships;
    private List<EarningRule> earningRules;
    private List<Reward> rewards;
    private List<Campaign> campaigns;
}
