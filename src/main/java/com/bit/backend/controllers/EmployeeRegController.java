package com.bit.backend.controllers;

import com.bit.backend.dtos.EmployeeRegDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.EmployeeRegServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
//@RequestMapping("/employee_reg_form")
public class EmployeeRegController {

//    private final EmployeeRegServiceI employeeRegService;
//
//    public EmployeeRegController(EmployeeRegServiceI employeeRegService) {
//        this.employeeRegService = employeeRegService;
//    }


    private final EmployeeRegServiceI employeeRegServiceI;

    public EmployeeRegController(EmployeeRegServiceI employeeRegServiceI) {
        this.employeeRegServiceI = employeeRegServiceI;
    }

    @PostMapping("/employee_reg_form")
    public ResponseEntity<EmployeeRegDto> registerEmployee(@RequestBody EmployeeRegDto employeeRegDto) {

        try{
            EmployeeRegDto savedDto = employeeRegServiceI.addEmployeeRegEntity(employeeRegDto);
            System.out.println(savedDto.getFirstName());
            return ResponseEntity.created(URI.create("/employee_reg_form" + savedDto.getId())).body(savedDto);
//        return ResponseEntity.ok(savedDto);
        } catch (Exception e){
            throw new AppException("Request failed with error:" + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/employee_reg_form")
    public ResponseEntity<List<EmployeeRegDto>> getData() {

        try{
            //data in the backend is sent as a List
            List<EmployeeRegDto> employeeRegDtoList = employeeRegServiceI.getData();
            return ResponseEntity.ok(employeeRegDtoList);
            //calls the getData() func. in Service(Interface)
            //and stores the retrieved data as a DTO List in employeeDtoList.
        } catch (Exception e){
            throw new AppException("Request failed with error:" + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/employee_reg_form/{id}")
    public ResponseEntity<EmployeeRegDto> deleteEmployee(@PathVariable long id) {

        try{
            EmployeeRegDto employeeRegDto= employeeRegServiceI.deleteEmployeeReg(id);
            return ResponseEntity.ok(employeeRegDto);
        } catch (Exception e){
            throw new AppException("Request failed with error:" + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

