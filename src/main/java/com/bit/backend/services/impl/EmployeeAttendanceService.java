package com.bit.backend.services.impl;

import com.bit.backend.dtos.EmployeeAttendanceDto;
import com.bit.backend.entities.EmployeeAttendanceEntity;
import com.bit.backend.mappers.EmployeeAttendanceMapper;
import com.bit.backend.repositories.EmployeeAttendanceRepository;
import com.bit.backend.services.EmployeeAttendanceServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeAttendanceService implements EmployeeAttendanceServiceI {

    private final EmployeeAttendanceRepository repository;
    private final EmployeeAttendanceMapper mapper;

    @Autowired
    public EmployeeAttendanceService(EmployeeAttendanceRepository repository, EmployeeAttendanceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public EmployeeAttendanceDto addEmployeeAttendance(EmployeeAttendanceDto attendanceDto) {
        EmployeeAttendanceEntity entity = mapper.toEmployeeAttendanceEntity(attendanceDto);
        EmployeeAttendanceEntity saved = repository.save(entity);
        return mapper.toEmployeeAttendanceDto(saved);
    }

    @Override
    public List<EmployeeAttendanceDto> getAllAttendance() {
        List<EmployeeAttendanceEntity> entities = repository.findAll();
        return entities.stream()
                .map(mapper::toEmployeeAttendanceDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeAttendanceDto updateEmployeeAttendance(long id, EmployeeAttendanceDto attendanceDto) {
        EmployeeAttendanceEntity existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attendance record not found: " + id));

        existing.setEmployeeName(attendanceDto.getEmployeeName());
        existing.setStatus(attendanceDto.getStatus());
        existing.setDate(attendanceDto.getDate());

        EmployeeAttendanceEntity updated = repository.save(existing);
        return mapper.toEmployeeAttendanceDto(updated);
    }

    @Override
    public void deleteEmployeeAttendance(long id) {
        repository.deleteById(id);
    }
}
