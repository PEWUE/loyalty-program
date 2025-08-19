package com.PEWUE.loyalty_program.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Membership {
    private Long id;
    private User user;
    private LoyaltyProgram loyaltyProgram;
    private LocalDateTime joinDate;
    private Long pointsBalance;
    private List<PointsTransaction> transactions;
}
