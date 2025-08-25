package com.PEWUE.loyalty_program.mapper;

import com.PEWUE.loyalty_program.dto.MembershipDTO;
import com.PEWUE.loyalty_program.model.Membership;
import com.PEWUE.loyalty_program.util.CycleAvoidingMappingContext;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class, LoyaltyProgramMapper.class, PointsTransactionMapper.class})
public interface MembershipMapper {
    MembershipDTO toDto(Membership membership, @Context CycleAvoidingMappingContext context);
    Membership toEntity(MembershipDTO dto, @Context CycleAvoidingMappingContext context);
}
