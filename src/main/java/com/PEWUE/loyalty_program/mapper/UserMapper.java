//package com.PEWUE.loyalty_program.mapper;
//
//import com.PEWUE.loyalty_program.dto.UserDTO;
//import com.PEWUE.loyalty_program.dto.UserRegistrationDTO;
//import com.PEWUE.loyalty_program.model.Membership;
//import com.PEWUE.loyalty_program.model.User;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.Named;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Mapper(componentModel = "spring")
//public interface UserMapper {
//    @Mapping(source = "memberships", target = "membershipIds", qualifiedByName = "mapMemberships")
//    UserDTO toDto(User user);
//
//    @Mapping(source = "membershipIds", target = "memberships", qualifiedByName = "mapMembershipIds")
//    User toEntity(UserDTO dto);
//
//    User toEntity(UserRegistrationDTO dto);
//
//    @Named("mapMemberships")
//    default List<Long> toMembershipIds(List<Membership> memberships) {
//        return Optional.ofNullable(memberships)
//                .orElse(new ArrayList<>())
//                .stream()
//                .map(Membership::getId)
//                .toList();
//    }
//
//    @Named("mapMembershipIds")
//    default List<Membership> toMemberships(List<Long> membershipIds) {
//        return Optional.ofNullable(membershipIds)
//                .orElse(new ArrayList<>())
//                .stream()
//                .map(id -> {
//                    Membership membership = new Membership();
//                    membership.setId(id);
//                    return membership;
//                })
//                .toList();
//    }
//}
