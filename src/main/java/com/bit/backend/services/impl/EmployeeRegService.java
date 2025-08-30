package com.bit.backend.services.impl;

import com.bit.backend.dtos.ClientRegDto;
import com.bit.backend.dtos.EmployeeRegDto;
import com.bit.backend.entities.EmployeeRegEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.EmployeeRegMapper;
import com.bit.backend.repositories.EmployeeRegRepository;
import com.bit.backend.services.EmployeeRegServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeRegService implements EmployeeRegServiceI {

    @Autowired
    private EmployeeRegRepository employeeRegRepository;

    @Autowired
    private EmployeeRegMapper employeeRegMapper;

    @Override
    public EmployeeRegDto addEmployeeRegEntity(EmployeeRegDto employeeRegDto) {

        try{
            EmployeeRegEntity employeeRegEntity = employeeRegMapper.toEmployeeRegEntity(employeeRegDto);
            EmployeeRegEntity savedItem = employeeRegRepository.save(employeeRegEntity);
            EmployeeRegDto savedEmployeeRegDto = employeeRegMapper.toEmployeeRegDto(savedItem);
            System.out.println("saved Successfully: " + savedEmployeeRegDto.getFirstName());
            // return employeeRegMapper.toEmployeeRegDto(savedItem);
            return savedEmployeeRegDto;
        }  catch (Exception e){
            throw new AppException("Request failed with error" + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public List<EmployeeRegDto> getData(){

        try {
            List<EmployeeRegEntity> employeeRegEntityList = employeeRegRepository.findAll();
            List<EmployeeRegDto> employeeRegDtoList = employeeRegMapper.toEmployeeRegDtoList(employeeRegEntityList);
            return employeeRegDtoList;
        } catch (Exception e){
            throw new AppException("Request failed with error" + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    

    @Override
    public EmployeeRegDto deleteEmployeeReg(long id) {

        try{
            //finds by ID if there is an existing record for the provided id, if not generates an error message.
            Optional<EmployeeRegEntity> optionalEmployeeRegEntity = employeeRegRepository.findById(id);

            if (!optionalEmployeeRegEntity.isPresent()) {
                throw new AppException("Employee Reg Entity does not exist", HttpStatus.BAD_REQUEST);
            }
            employeeRegRepository.deleteById(id);
            return employeeRegMapper.toEmployeeRegDto(optionalEmployeeRegEntity.get());
        } catch (Exception e){
            throw new AppException("Request failed with error" + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public EmployeeRegDto editEmployee(Long id, EmployeeRegDto employeeRegDto) {
        try {
            Optional<EmployeeRegEntity> findEmployeeEntity = employeeRegRepository.findById(id);
            if (!findEmployeeEntity.isPresent()){
                throw new AppException("Employee does not exist", HttpStatus.BAD_REQUEST);
            }

            EmployeeRegEntity newEmployeeRegEntity = employeeRegMapper.toEmployeeRegEntity(employeeRegDto);
            newEmployeeRegEntity.setId(id);
            EmployeeRegEntity employeeRegEntity = employeeRegRepository.save(newEmployeeRegEntity);
            EmployeeRegDto employeeRegDtoRes = employeeRegMapper.toEmployeeRegDto(employeeRegEntity);
            System.out.println("update Successfully: " + employeeRegDtoRes.getFirstName());
            return employeeRegDtoRes;
        }catch (Exception e) {
            throw new AppException("Request failed with error " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


