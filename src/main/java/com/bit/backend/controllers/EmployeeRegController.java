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

    private final EmployeeRegServiceI employeeRegServiceI;

    public EmployeeRegController(EmployeeRegServiceI employeeRegServiceI) {
        this.employeeRegServiceI = employeeRegServiceI;
    }

    @PostMapping("/employee_reg")
    public ResponseEntity<EmployeeRegDto> registerEmployee(@RequestBody EmployeeRegDto employeeRegDto) {

        try{
            EmployeeRegDto savedDto = employeeRegServiceI.addEmployeeRegEntity(employeeRegDto);
            return ResponseEntity.created(URI.create("/employee_reg_form" + savedDto.getId())).body(savedDto);
//        return ResponseEntity.ok(savedDto);
        } catch (Exception e){
            throw new AppException("Request failed with error:" + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/employee_edit/{id}")
    public ResponseEntity<EmployeeRegDto> editEmployee(@PathVariable Long id, @RequestBody EmployeeRegDto employeeRegDto){
        try {
            EmployeeRegDto employeeRegDtoRes = employeeRegServiceI.editEmployee(id,employeeRegDto);
            return ResponseEntity.ok(employeeRegDtoRes);
        }catch (Exception e){

            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR );
        }

    }

    @GetMapping("/employee_get")
    public ResponseEntity<List<EmployeeRegDto>> getData() {

        try{
            List<EmployeeRegDto> employeeRegDtoList = employeeRegServiceI.getData();
            return ResponseEntity.ok(employeeRegDtoList);
        } catch (Exception e){
            throw new AppException("Request failed with error:" + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/employee_delete/{id}")
    public ResponseEntity<EmployeeRegDto> deleteEmployee(@PathVariable long id) {

        try{
            EmployeeRegDto employeeRegDto= employeeRegServiceI.deleteEmployeeReg(id);
            return ResponseEntity.ok(employeeRegDto);
        } catch (Exception e){
            throw new AppException("Request failed with error:" + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

