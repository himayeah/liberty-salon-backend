package com.bit.backend.services;

import com.bit.backend.dtos.ClientRegDto;
import com.bit.backend.dtos.EmployeeRegDto;

import java.util.List;

// Create a method named "addClientReg" and declare it in ClientRegServiceI
public interface EmployeeRegServiceI {

    EmployeeRegDto addEmployeeRegEntity(EmployeeRegDto employeeRegDto);
}
