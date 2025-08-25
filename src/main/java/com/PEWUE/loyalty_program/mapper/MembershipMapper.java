package com.PEWUE.loyalty_program.mapper;

import com.PEWUE.loyalty_program.dto.MembershipDTO;
import com.PEWUE.loyalty_program.model.Membership;
import com.PEWUE.loyalty_program.util.CycleAvoidingMappingContext;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class, LoyaltyProgramMapper.class, PointsTransactionMapper.class})
public interface MembershipMapper {
    @Mapping(source = "user", target = "userDTO")
    @Mapping(source = "loyaltyProgram", target = "loyaltyProgramDTO")
    @Mapping(source = "transactions", target = "transactionDTOS")
    MembershipDTO toDto(Membership membership, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "userDTO", target = "user")
    @Mapping(source = "loyaltyProgramDTO", target = "loyaltyProgram")
    @Mapping(source = "transactionDTOS", target = "transactions")
    Membership toEntity(MembershipDTO dto, @Context CycleAvoidingMappingContext context);
}
