package com.bit.backend.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointment_schedule")
public class AppointmentScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="service_name")
    private String serviceName;

    @Column(name="service_description")
    private String serviceDescription;

    @Column(name="date")
    private LocalDate date;

    @Column(name="time")
    private LocalTime time;

    public AppointmentScheduleEntity() {
    }

    public AppointmentScheduleEntity(Long id, String serviceName, String serviceDescription, LocalDate date, LocalTime time) {
        this.id = id;
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
        this.date = date;
        this.time = time;
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
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
