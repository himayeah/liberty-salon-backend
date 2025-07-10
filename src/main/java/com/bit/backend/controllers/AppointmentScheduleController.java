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
@RequestMapping("/appointment-scheduling-form")  // Base path for all appointment-schedule endpoints
public class AppointmentScheduleController {

    private final AppointmentScheduleServiceI appointmentScheduleServiceI;

    public AppointmentScheduleController(AppointmentScheduleServiceI appointmentScheduleServiceI) {
        this.appointmentScheduleServiceI = appointmentScheduleServiceI;
    }

    @PostMapping("/appointment-scheduling-form")
    public ResponseEntity<AppointmentScheduleDto> addForm(@RequestBody AppointmentScheduleDto appointmentScheduleDto) throws AppException {
        try {
            AppointmentScheduleDto appointmentDtoResponse = appointmentScheduleServiceI.addAppointmentScheduleEntity(appointmentScheduleDto);
            return ResponseEntity.created(URI.create("/appointment-schedule/" + appointmentDtoResponse.getServiceName()))
                    .body(appointmentDtoResponse);
        } catch (Exception e) {
            throw new AppException("Request failed with error:" + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/appointment-scheduling-form")
    public ResponseEntity<List<AppointmentScheduleDto>> getData() {
        try {
            List<AppointmentScheduleDto> appointmentDtoList = appointmentScheduleServiceI.getData();
            return ResponseEntity.ok(appointmentDtoList);
        } catch (Exception e) {
            throw new AppException("Request failed with error:" + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentScheduleDto> updateAppointment(
            @PathVariable long id,
            @RequestBody AppointmentScheduleDto appointmentScheduleDto) {
        try {
            AppointmentScheduleDto responseAppointmentDto = appointmentScheduleServiceI.updateAppointmentScheduleEntity(id, appointmentScheduleDto);
            return ResponseEntity.ok(responseAppointmentDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error:" + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/appointment-scheduling-form/{id}")
    public ResponseEntity<AppointmentScheduleDto> deleteAppointment(@PathVariable long id) {
        try {
            AppointmentScheduleDto deletedDto = appointmentScheduleServiceI.deleteAppointmentScheduleEntity(id);
            return ResponseEntity.ok(deletedDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error:" + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}