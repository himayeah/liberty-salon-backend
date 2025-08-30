package com.bit.backend.mappers;

import com.bit.backend.dtos.EmployeeAttendanceDto;
import com.bit.backend.entities.EmployeeAttendanceEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeAttendanceMapper {

    EmployeeAttendanceDto toEmployeeAttendanceDto(EmployeeAttendanceEntity entity);

    EmployeeAttendanceEntity toEmployeeAttendanceEntity(EmployeeAttendanceDto dto);

    List<EmployeeAttendanceDto> toEmployeeAttendanceDtoList(List<EmployeeAttendanceEntity> entityList);
}
