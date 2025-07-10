package com.bit.backend.mappers;

import com.bit.backend.dtos.AppointmentScheduleDto;
import com.bit.backend.entities.AppointmentScheduleEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppointmentScheduleMapper {

    AppointmentScheduleDto toAppointmentScheduleDto(AppointmentScheduleEntity appointmentScheduleEntity);

    AppointmentScheduleEntity toAppointmentScheduleEntity(AppointmentScheduleDto appointmentScheduleDto);

    List<AppointmentScheduleDto> toAppointmentScheduleDtoList(List<AppointmentScheduleEntity> appointmentScheduleEntityList);
}
