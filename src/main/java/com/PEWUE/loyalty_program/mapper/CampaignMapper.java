//package com.PEWUE.loyalty_program.mapper;
//
//import com.PEWUE.loyalty_program.dto.CampaignDTO;
//import com.PEWUE.loyalty_program.model.Campaign;
//import com.PEWUE.loyalty_program.model.LoyaltyProgram;
//import com.PEWUE.loyalty_program.model.Period;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//
//import java.time.LocalDateTime;
//
//@Mapper(componentModel = "spring")
//public interface CampaignMapper {
//    @Mapping(source = "period.startDate", target = "startDate")
//    @Mapping(source = "period.endDate", target = "endDate")
//    @Mapping(target = "eventType", expression = "java(campaign.getEventType().name())")
//    @Mapping(target = "loyaltyProgramId", expression = "java(campaign.getLoyaltyProgram().getId())")
//    CampaignDTO toDto(Campaign campaign);
//
//    @Mapping(target = "period", expression = "java(toPeriod(dto.getStartDate(), dto.getEndDate())")
//    @Mapping(target = "loyaltyProgram", expression = "java(toLoyaltyProgram())")
//    Campaign toEntity(CampaignDTO dto);
//
//    default Period toPeriod(LocalDateTime startDate, LocalDateTime endDate) {
//        if (startDate == null && endDate == null) {
//            return null;
//        }
//        return Period.builder()
//                .startDate(startDate)
//                .endDate(endDate)
//                .build();
//    }
//
//    default LoyaltyProgram toLoyaltyProgram(Long loyaltyProgramId) {
//        if (loyaltyProgramId == null) {
//            return null;
//        }
//        return LoyaltyProgram.builder()
//                .id(loyaltyProgramId)
//                .build();
//    }
//}
