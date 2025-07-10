package com.bit.backend.services;

import com.bit.backend.dtos.AppointmentScheduleDto;

import java.util.List;

public interface AppointmentScheduleServiceI {

    // Method to add appointment
    AppointmentScheduleDto addAppointmentScheduleEntity(AppointmentScheduleDto appointmentScheduleDto);

    // Method to retrieve all appointments
    List<AppointmentScheduleDto> getData();

    // Method to update appointment by id
    AppointmentScheduleDto updateAppointmentScheduleEntity(long id, AppointmentScheduleDto appointmentScheduleDto);

    // Method to delete appointment by id
    AppointmentScheduleDto deleteAppointmentScheduleEntity(long id);
}
