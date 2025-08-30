package com.bit.backend.controllers;

import com.bit.backend.dtos.EmployeeAttendanceDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.EmployeeAttendanceServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

    @RestController
    public class EmployeeAttendanceController {

    private final EmployeeAttendanceServiceI employeeAttendanceServiceI;

    public EmployeeAttendanceController(EmployeeAttendanceServiceI employeeAttendanceServiceI) {
        this.employeeAttendanceServiceI = employeeAttendanceServiceI;
    }

    @PostMapping("/employee-attendance")
    public ResponseEntity<EmployeeAttendanceDto> addAttendance(@RequestBody EmployeeAttendanceDto attendanceDto) {
        try {
            EmployeeAttendanceDto savedDto = employeeAttendanceServiceI.addEmployeeAttendance(attendanceDto);
            return ResponseEntity.created(URI.create("/employee-attendance" + savedDto.getId())).body(savedDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employee-attendance")
    public ResponseEntity<List<EmployeeAttendanceDto>> getAllAttendance() {
        try {
            List<EmployeeAttendanceDto> attendanceList = employeeAttendanceServiceI.getAllAttendance();
            return ResponseEntity.ok(attendanceList);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/employee-attendance/{id}")
    public ResponseEntity<EmployeeAttendanceDto> updateAttendance(@PathVariable long id, @RequestBody EmployeeAttendanceDto attendanceDto) {
        try {
            EmployeeAttendanceDto updatedDto = employeeAttendanceServiceI.updateEmployeeAttendance(id, attendanceDto);
            return ResponseEntity.ok(updatedDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/employee-attendance/{id}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable long id) {
        try {
            employeeAttendanceServiceI.deleteEmployeeAttendance(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
