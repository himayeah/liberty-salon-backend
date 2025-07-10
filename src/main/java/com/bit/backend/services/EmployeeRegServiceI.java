package com.bit.backend.services;

import com.bit.backend.dtos.EmployeeRegDto;

import java.util.List;

// Create a method named "addClientReg" and declare it in ClientRegServiceI
public interface EmployeeRegServiceI {

    //Method to add Employee data
    EmployeeRegDto addEmployeeRegEntity(EmployeeRegDto employeeRegDto);

    //Method to get Employee data
    List<EmployeeRegDto> getData();

    //deleteEmployeeReg
    EmployeeRegDto deleteEmployeeReg(long id);
}


