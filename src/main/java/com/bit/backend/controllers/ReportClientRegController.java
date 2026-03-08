package com.bit.backend.controllers;

import com.bit.backend.dtos.AppointmentScheduleDto;
import com.bit.backend.dtos.ClientRegDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.AppointmentScheduleServiceI;
import com.bit.backend.services.ReportClientRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/report-client-controller")
public class ReportClientRegController {

    @Autowired
    private ReportClientRegService reportClientRegService;

    @GetMapping
    public ResponseEntity<List<ClientRegDto>> getData() {
        try{
            //***calls the getData() function in the ServiceI, does whatever the functionality it's asking to do, and saves the result of it in clientRegDtoList
            List<ClientRegDto> clientRegDtoList = reportClientRegService.getAllClientsData();
            return ResponseEntity.ok(clientRegDtoList);
        } catch (Exception e) {
            throw new AppException("Request failed with error:" + e, HttpStatus.INTERNAL_SERVER_ERROR);}
    }
}
