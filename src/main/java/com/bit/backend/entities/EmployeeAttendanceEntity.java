package com.bit.backend.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "employee_attendance")
public class EmployeeAttendanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "status")
    private String status;

//    @Temporal(TemporalType.DATE)
//    @Column(name = "date")
//    private Date date;

    @Column(name="date")
    private LocalDate date;

    public EmployeeAttendanceEntity() {
    }

    public EmployeeAttendanceEntity(Long id, String employeeName, String status, LocalDate date) {
        this.id = id;
        this.employeeName = employeeName;
        this.status = status;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
