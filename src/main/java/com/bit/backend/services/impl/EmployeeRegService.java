package com.bit.backend.services.impl;

import com.bit.backend.dtos.ClientRegDto;
import com.bit.backend.dtos.EmployeeRegDto;
import com.bit.backend.entities.EmployeeRegEntity;
import com.bit.backend.mappers.EmployeeRegMapper;
import com.bit.backend.repositories.EmployeeRegRepository;
import com.bit.backend.services.EmployeeRegServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeRegService implements EmployeeRegServiceI {

    private final EmployeeRegRepository employeeRegRepository;
    private final EmployeeRegMapper employeeRegMapper;

    public EmployeeRegService(EmployeeRegRepository employeeRegRepository, EmployeeRegMapper employeeRegMapper) {
        this.employeeRegRepository = employeeRegRepository;
        this.employeeRegMapper = employeeRegMapper;
    }

    @Override
    public EmployeeRegDto addEmployeeRegEntity(EmployeeRegDto employeeRegDto) {
        EmployeeRegEntity employeeRegEntity = employeeRegMapper.toEmployeeRegEntity(employeeRegDto);
        EmployeeRegEntity savedItem = employeeRegRepository.save(employeeRegEntity);

        EmployeeRegDto savedEmployeeRegDto = employeeRegMapper.toEmployeeRegDto(savedItem);
//        System.out.println("saved Successfully: " + savedEmployeeRegDto.getFirstName());
//        return employeeRegMapper.toEmployeeRegDto(savedItem);
        return savedEmployeeRegDto;
    }
}


