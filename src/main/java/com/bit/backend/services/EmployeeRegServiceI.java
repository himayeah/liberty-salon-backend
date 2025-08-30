package com.bit.backend.services;

import com.bit.backend.dtos.EmployeeRegDto;

import java.util.List;

public interface EmployeeRegServiceI {

    EmployeeRegDto addEmployeeRegEntity(EmployeeRegDto employeeRegDto);

    //Method to get Employee data
    List<EmployeeRegDto> getData();

    //deleteEmployeeReg
    EmployeeRegDto deleteEmployeeReg(long id);
    //updateEmployee
    EmployeeRegDto editEmployee(Long id, EmployeeRegDto employeeRegDto);
}


