package com.bit.backend.mappers;


import com.bit.backend.dtos.EmployeeRegDto;
import com.bit.backend.entities.EmployeeRegEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring" , builder = @Builder(disableBuilder = true))
public interface EmployeeRegMapper {
    EmployeeRegDto toEmployeeRegDto(EmployeeRegEntity employeeRegEntity);
    EmployeeRegEntity toEmployeeRegEntity(EmployeeRegDto  employeeRegDto);

    //getData
    List<EmployeeRegDto> toEmployeeRegDtoList(List<EmployeeRegEntity> employeeRegEntityList);
    //converting the Entity list into a Dto list

}