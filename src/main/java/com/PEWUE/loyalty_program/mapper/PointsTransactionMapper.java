package com.PEWUE.loyalty_program.mapper;

import com.PEWUE.loyalty_program.dto.PointsTransactionDTO;
import com.PEWUE.loyalty_program.dto.PointsTransactionRequestDTO;
import com.PEWUE.loyalty_program.enums.TransactionType;
import com.PEWUE.loyalty_program.model.PointsTransaction;
import com.PEWUE.loyalty_program.util.CycleAvoidingMappingContext;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = MembershipMapper.class)
public interface PointsTransactionMapper {
    @Mapping(source = "membership", target = "membershipDTO")
    @Mapping(target = "transactionType", expression = "java(transaction.getTransactionType().name())")
    PointsTransactionDTO toDto(PointsTransaction transaction, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "membershipDTO", target = "membership")
    @Mapping(target = "transactionType", expression = "java(stringToTransactionType(dto.getTransactionType()))")
    PointsTransaction toEntity(PointsTransactionDTO dto, @Context CycleAvoidingMappingContext context);

    @Mapping(target = "membership", ignore = true)
    //TODO ustaw membership w serwisie po ID z DTO
    @Mapping(target = "transactionType", expression = "java(stringToTransactionType(dto.getTransactionType()))")
    PointsTransaction toEntity(PointsTransactionRequestDTO dto, @Context CycleAvoidingMappingContext context);

    default TransactionType stringToTransactionType(String transactionType) {
        if (transactionType == null) {
            return null;
        }
        try {
            return TransactionType.valueOf(transactionType);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
