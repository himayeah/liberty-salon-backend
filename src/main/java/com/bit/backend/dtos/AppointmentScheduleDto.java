package com.bit.backend.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentScheduleDto {

    private Long id;
    private String serviceName;
    private String serviceDescription;
    private LocalDate serviceDate;
    private LocalTime serviceTime;

    public AppointmentScheduleDto() {
    }

    public AppointmentScheduleDto(Long id, String serviceName, String serviceDescription, LocalDate date, LocalTime time) {
        this.id = id;
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
        this.serviceDate = date;
        this.serviceTime = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public LocalDate getDate() {
        return serviceDate;
    }

    public void setDate(LocalDate date) {
        this.serviceDate = date;
    }

    public LocalTime getTime() {
        return serviceTime;
    }

    public void setTime(LocalTime time) {
        this.serviceTime = time;
    }
}

