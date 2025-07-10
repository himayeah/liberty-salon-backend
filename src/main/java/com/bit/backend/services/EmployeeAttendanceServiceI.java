package com.bit.backend.services;

import com.bit.backend.dtos.EmployeeAttendanceDto;

import java.util.List;

public interface EmployeeAttendanceServiceI {

    // Add new employee attendance record
    EmployeeAttendanceDto addEmployeeAttendance(EmployeeAttendanceDto attendanceDto);

    // Get all employee attendance records
    List<EmployeeAttendanceDto> getAllAttendance();

    // Update existing attendance by ID
    EmployeeAttendanceDto updateEmployeeAttendance(long id, EmployeeAttendanceDto attendanceDto);

    // Delete attendance record by ID
    void deleteEmployeeAttendance(long id);
}
