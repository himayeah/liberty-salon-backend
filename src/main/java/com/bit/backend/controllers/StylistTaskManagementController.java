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
public class StylistTaskManagementController {

    private final StylistTaskManagementServiceI stylistTaskManagementServiceI;

    public StylistTaskManagementController(StylistTaskManagementServiceI stylistTaskManagementServiceI) {
        this.stylistTaskManagementServiceI = stylistTaskManagementServiceI;
    }

    @PostMapping("/add-stylist-task")
    public ResponseEntity<StylistTaskManagementDto> addStylistTask(@RequestBody StylistTaskManagementDto stylistTaskManagementDto){
        try {
            StylistTaskManagementDto resStylistTaskManagementDto = stylistTaskManagementServiceI.addStylistTask(stylistTaskManagementDto);
            return ResponseEntity.created(URI.create("/add-stylist-task"+resStylistTaskManagementDto.getStylistName())).body(resStylistTaskManagementDto);
            //        return ResponseEntity.ok(resStylistTaskManagementDto);
        }catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-stylist-tasks")
    public ResponseEntity<List<StylistTaskManagementDto>> getStylistTask() {
        try{
            List<StylistTaskManagementDto> StylistTaskManagementDtoList = stylistTaskManagementServiceI.getStylistTask();
            return ResponseEntity.ok(StylistTaskManagementDtoList);
        }catch (Exception e){
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @PutMapping(path ="/edit-stylist-task/{id}")
    public ResponseEntity<StylistTaskManagementDto> editStylistTask(@PathVariable Long id, @RequestBody StylistTaskManagementDto stylistTaskManagementDto){
        try{
            StylistTaskManagementDto stylistTaskManagementDtoRes = stylistTaskManagementServiceI.editStylistTask(id,stylistTaskManagementDto);

          //  System.out.println("updated stylistTask: " + stylistTaskManagementDtoRes.getStylistName()); ////////// for test ////

            return ResponseEntity.ok(stylistTaskManagementDtoRes);
        }catch (Exception e){
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "/delete-stylist-task/{id}")
    public ResponseEntity<StylistTaskManagementDto> deleteStylistTask(@PathVariable Long id){
        try{
            StylistTaskManagementDto stylistTaskManagementDtoRes = stylistTaskManagementServiceI.deleteStylistTask(id);
            return ResponseEntity.ok(stylistTaskManagementDtoRes);
        }catch (Exception e){
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
