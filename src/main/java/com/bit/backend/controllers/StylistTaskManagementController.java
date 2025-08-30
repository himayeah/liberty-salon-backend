package com.bit.backend.controllers;

import com.bit.backend.dtos.StylistTaskManagementDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.StylistTaskManagementServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/stylist-task-management")
public class StylistTaskManagementController {

    private final StylistTaskManagementServiceI stylistTaskManagementServiceI;

    public StylistTaskManagementController(StylistTaskManagementServiceI stylistTaskManagementServiceI) {
        this.stylistTaskManagementServiceI = stylistTaskManagementServiceI;
    }

    @PostMapping
    public ResponseEntity<StylistTaskManagementDto> addStylistTaskManagement(@RequestBody StylistTaskManagementDto stylistTaskManagementDto) throws AppException {
        try {
            StylistTaskManagementDto savedDto = stylistTaskManagementServiceI.addStylistTaskManagement(stylistTaskManagementDto);
            return ResponseEntity.created(URI.create("/stylist-task-management/" + savedDto.getId()))
                    .body(savedDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<StylistTaskManagementDto>> getData() {
        try {
            List<StylistTaskManagementDto> dtoList = stylistTaskManagementServiceI.getData();
            return ResponseEntity.ok(dtoList);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<StylistTaskManagementDto> updateStylistTaskManagement(
            @PathVariable long id,
            @RequestBody StylistTaskManagementDto stylistTaskManagementDto) {
        try {
            StylistTaskManagementDto updatedDto = stylistTaskManagementServiceI.updateStylistTaskManagement(id, stylistTaskManagementDto);
            return ResponseEntity.ok(updatedDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStylistTaskManagement(@PathVariable long id) {
        try {
            stylistTaskManagementServiceI.deleteStylistTaskManagement(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
