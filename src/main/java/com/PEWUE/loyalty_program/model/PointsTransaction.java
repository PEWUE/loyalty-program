package com.PEWUE.loyalty_program.model;

import com.PEWUE.loyalty_program.enums.TransactionType;
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
public class PointsTransaction {
    private Long id;
    private Membership membership;
    private TransactionType transactionType;
    private Long points;
    private String description;
    private LocalDateTime transactionDate;
    private Long balanceAfterTransaction;
}
