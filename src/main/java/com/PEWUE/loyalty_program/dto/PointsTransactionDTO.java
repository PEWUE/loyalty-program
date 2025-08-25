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
public class PointsTransactionDTO {
    private Long id;
    private String transactionType;
    private Long points;
    private String description;
    private LocalDateTime transactionDate;
    private Long balanceAfterTransaction;
    private MembershipDTO membershipDTO;
}
