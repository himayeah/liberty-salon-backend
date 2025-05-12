package com.bit.backend.controllers;

import com.bit.backend.dtos.EmployeeRegDto;
import com.bit.backend.services.EmployeeRegServiceI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

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
       EmployeeRegDto savedDto = employeeRegServiceI.addEmployeeRegEntity(employeeRegDto);
        System.out.println(savedDto.getFirstName());
        return ResponseEntity.created(URI.create("/employee_reg_form" + savedDto.getId())).body(savedDto);
//        return ResponseEntity.ok(savedDto);
    }
}

