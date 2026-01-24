package com.bit.backend.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientRegDto {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String dateOfBirth;
    private String gender;
    private String preferredStylist;
    private String allergies;
    private int totalVisits;
    private String lastVisitedDate;
    private double lifetimeValue;

    public ClientRegDto() {
    }

    public ClientRegDto(long id, String firstName, String lastName, String email, String phoneNumber, String dateOfBirth, String gender, String preferredStylist, String allergies, int totalVisits, String lastVisitedDate, double lifetimeValue) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.preferredStylist = preferredStylist;
        this.allergies = allergies;
        this.totalVisits = totalVisits;
        this.lastVisitedDate = lastVisitedDate;
        this.lifetimeValue = lifetimeValue;
    }
}


