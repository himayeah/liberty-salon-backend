package com.bit.backend.mappers;


import com.bit.backend.dtos.EmployeeRegDto;
import com.bit.backend.entities.EmployeeRegEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring" , builder = @Builder(disableBuilder = true))
public interface EmployeeRegMapper {
    EmployeeRegDto toEmployeeRegDto(EmployeeRegEntity employeeRegEntity);
    EmployeeRegEntity toEmployeeRegEntity(EmployeeRegDto  employeeRegDto);
}