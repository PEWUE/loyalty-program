package com.PEWUE.loyalty_program.dto;

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
public class MembershipDTO {
    private Long id;
    private UserDTO userDTO;
    private LoyaltyProgramDTO loyaltyProgramDTO;
    private LocalDateTime joinDate;
    private Long pointsBalance;
    private List<PointsTransactionDTO> transactionDTOS;
}
