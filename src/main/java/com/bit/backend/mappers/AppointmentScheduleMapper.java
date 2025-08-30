package com.bit.backend.mappers;

import com.bit.backend.dtos.AppointmentScheduleDto;
import com.bit.backend.dtos.EmployeeRegDto;
import com.bit.backend.entities.AppointmentScheduleEntity;
import com.bit.backend.entities.EmployeeRegEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring" , builder = @Builder(disableBuilder = true))
public interface AppointmentScheduleMapper {
    AppointmentScheduleDto toAppointmentScheduleDto(AppointmentScheduleEntity appointmentScheduleEntity);
    AppointmentScheduleEntity toAppointmentScheduleEntity(AppointmentScheduleDto appointmentScheduleDto);
    List<AppointmentScheduleDto> toAppointmentScheduleDtoList(List<AppointmentScheduleEntity> appointmentScheduleEntities);
}
