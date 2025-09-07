package com.bit.backend.services;

import com.bit.backend.dtos.AppointmentScheduleDto;

import java.util.List;

public interface AppointmentScheduleServiceI {
    AppointmentScheduleDto addAppointmentSchedule(AppointmentScheduleDto appointmentScheduleDto);
    List<AppointmentScheduleDto> getData();
    AppointmentScheduleDto deleteData(long id);
    AppointmentScheduleDto editData(long id, AppointmentScheduleDto appointmentScheduleDto);

   // AppointmentScheduleDto editData(long id, AppointmentScheduleDto appointmentScheduleDto);
}
