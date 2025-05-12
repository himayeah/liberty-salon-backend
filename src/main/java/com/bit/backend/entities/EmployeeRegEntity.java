package com.bit.backend.entities;


import jakarta.persistence.*;

@Entity
@Table(name="employee_reg")
public class EmployeeRegEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name= "first_name")
    private String firstName;

    @Column (name= "last_name")
    private String lastName;

    @Column (name= "full_name")
    private String fullName;

    @Column(name= "age")
    private String age;

    @Column (name = "email")
    private String email;

    @Column (name="phone_number")
    private String phoneNumber;

    @Column (name= "blood_type")
    private String bloodType;

}
