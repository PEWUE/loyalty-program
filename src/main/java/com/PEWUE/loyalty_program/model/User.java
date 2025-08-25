package com.PEWUE.loyalty_program.model;

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
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDateTime registrationDate;
    private List<Membership> memberships;
    private List<PointsTransaction> pointsTransactions;

    public User update(User newData) {
        this.firstName = newData.getFirstName();
        this.lastName = newData.getLastName();
        this.email = newData.getEmail();
        this.registrationDate = newData.getRegistrationDate();
        this.memberships = newData.getMemberships();
        this.pointsTransactions = newData.getPointsTransactions();
        return this;
    }
}
