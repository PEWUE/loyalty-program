package com.PEWUE.loyalty_program.dto;

import com.PEWUE.loyalty_program.enums.TransactionType;
import com.PEWUE.loyalty_program.model.Membership;
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
public class PointsTransactionRequestDTO {
    private Long membershipId;
    private String transactionType;
    private Long points;
    private String description;
}
