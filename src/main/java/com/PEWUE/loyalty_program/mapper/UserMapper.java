package com.PEWUE.loyalty_program.mapper;

import com.PEWUE.loyalty_program.dto.UserDTO;
import com.PEWUE.loyalty_program.dto.UserRegistrationDTO;
import com.PEWUE.loyalty_program.dto.UserUpdateDTO;
import com.PEWUE.loyalty_program.model.User;
import com.PEWUE.loyalty_program.util.CycleAvoidingMappingContext;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = MembershipMapper.class)
public interface UserMapper {
    UserDTO toDto(User user, @Context CycleAvoidingMappingContext context);
    User toEntity(UserDTO dto, @Context CycleAvoidingMappingContext context);
    User toEntity(UserRegistrationDTO dto, @Context CycleAvoidingMappingContext context);
    User toEntity(UserUpdateDTO dto, @Context CycleAvoidingMappingContext context);
}
