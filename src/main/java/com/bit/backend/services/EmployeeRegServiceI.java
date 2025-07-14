package com.bit.backend.services;

import com.bit.backend.dtos.EmployeeRegDto;

import java.util.List;

public interface EmployeeRegServiceI {

    EmployeeRegDto addEmployeeRegEntity(EmployeeRegDto employeeRegDto);

    List<EmployeeRegDto> getData();

    EmployeeRegDto deleteEmployeeReg(long id);

    EmployeeRegDto updateEmployeeReg(long id, EmployeeRegDto employeeRegDto);

}


