package com.bit.backend.dtos;

import java.time.LocalDate;
import java.util.Date;

public class EmployeeAttendanceDto {

    private Long id;
    private String employeeName;
    private String status;
    private LocalDate date;

    public EmployeeAttendanceDto() {
    }

    public EmployeeAttendanceDto(Long id, String employeeName, String status, LocalDate date) {
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
