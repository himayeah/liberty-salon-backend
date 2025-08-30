package com.bit.backend.controllers;

import com.bit.backend.dtos.AppointmentScheduleDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.AppointmentScheduleServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/appointment-schedule") // ✅ Base path
@CrossOrigin(origins = "*") // Optional: allow frontend to access the backend
public class AppointmentScheduleController {

    private final AppointmentScheduleServiceI appointmentScheduleServiceI;

    public AppointmentScheduleController(AppointmentScheduleServiceI appointmentScheduleServiceI) {
        this.appointmentScheduleServiceI = appointmentScheduleServiceI;
    }

    // ✅ Create a new appointment
    @PostMapping
    public ResponseEntity<AppointmentScheduleDto> addAppointment(@RequestBody AppointmentScheduleDto appointmentScheduleDto) {
        try {
            AppointmentScheduleDto savedDto = appointmentScheduleServiceI.addAppointmentSchedule(appointmentScheduleDto);
            return ResponseEntity.created(URI.create("/appointment-schedule/" + savedDto.getId())).body(savedDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // ✅ Update existing appointment by ID
    @PutMapping("/{id}")
    public ResponseEntity<AppointmentScheduleDto> editAppointment(@PathVariable Long id, @RequestBody AppointmentScheduleDto appointmentScheduleDto) {
        try {
            AppointmentScheduleDto updatedDto = appointmentScheduleServiceI.editData(id, appointmentScheduleDto);
            return ResponseEntity.ok(updatedDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // ✅ Get all appointments
    @GetMapping
    public ResponseEntity<List<AppointmentScheduleDto>> getAllAppointments() {
        try {
            List<AppointmentScheduleDto> appointmentList = appointmentScheduleServiceI.getData();
            return ResponseEntity.ok(appointmentList);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // ✅ Delete appointment by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<AppointmentScheduleDto> deleteAppointment(@PathVariable long id) {
        try {
            AppointmentScheduleDto deletedDto = appointmentScheduleServiceI.deleteData(id);
            return ResponseEntity.ok(deletedDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
