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

    public ClientRegDto() {
    }

    public ClientRegDto(long id, String firstName, String lastName, String email, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}




