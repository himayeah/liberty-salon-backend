package com.bit.backend.controllers;

import com.bit.backend.dtos.ClientRegDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.ClientRegServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/client-reg") // Base path for all client-reg endpoints
public class ClientRegController {

    private final ClientRegServiceI clientRegServiceI;

    public ClientRegController(ClientRegServiceI clientRegServiceI) {
        this.clientRegServiceI = clientRegServiceI;
    }

    @PostMapping
    public ResponseEntity<ClientRegDto> addForm(@RequestBody ClientRegDto clientRegDto) throws AppException {

        try{
            ClientRegDto clientRegDtoResponse = clientRegServiceI.addClientReg(clientRegDto);
            return ResponseEntity.created(URI.create("/client-reg/" + clientRegDtoResponse.getFirstName()))
                    .body(clientRegDtoResponse);
        } catch (Exception e) {
            throw new AppException("Request failed with error:" + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //If any exception occurs during the process, it catches it.
        //error handling p1. next go to : ClientRegService.java
    }

    @GetMapping
    public ResponseEntity<List<ClientRegDto>> getData() {

        try{
        List<ClientRegDto> clientRegDtoList = clientRegServiceI.getData();
        return ResponseEntity.ok(clientRegDtoList);
    } catch (Exception e) {
        throw new AppException("Request failed with error:" + e, HttpStatus.INTERNAL_SERVER_ERROR);}
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientRegDto> updateClientReg(
            @PathVariable long id,
            @RequestBody ClientRegDto clientRegDto) {
        try{
        ClientRegDto responseClientRegDto = clientRegServiceI.updateClientReg(id, clientRegDto);
        return ResponseEntity.ok(responseClientRegDto);
    }
        catch (Exception e) {
        throw new AppException("Request failed with error:" + e, HttpStatus.INTERNAL_SERVER_ERROR);}
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClientRegDto> deleteClientReg(@PathVariable long id) {

        try{
        //Defines a method that takes the id from the URL path and returns a ResponseEntity containing a ClientRegDto object.
        ClientRegDto clientRegDto = clientRegServiceI.deleteClientReg(id);
        //Calls a service method to delete the client with the given id, and stores the deleted client's data in clientRegDto.
        return ResponseEntity.ok(clientRegDto);
        //Returns an HTTP 200 OK response with the deleted client's data in the response body.
        //Next Step: Go to ClientRegServiceI
    }
        catch (Exception e) {
        throw new AppException("Request failed with error:" + e, HttpStatus.INTERNAL_SERVER_ERROR);}
    }

}
