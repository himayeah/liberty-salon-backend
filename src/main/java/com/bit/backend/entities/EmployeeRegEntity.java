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

    public EmployeeRegEntity(Long id, String firstName, String lastName, String fullName, String age, String email, String phoneNumber, String bloodType) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.bloodType = bloodType;
    }

    public EmployeeRegEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
}


