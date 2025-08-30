package com.bit.backend.dtos;

public class AppointmentScheduleDto {
    private Long id;
    private String serviceType;
    private String serviceDescription;
    private String appointmentDate;

    public AppointmentScheduleDto() {
    }
    public AppointmentScheduleDto(Long id, String serviceType, String serviceDescription, String appointmentDate) {
        this.id = id;
        this.serviceType = serviceType;
        this.serviceDescription = serviceDescription;
        this.appointmentDate = appointmentDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
}

