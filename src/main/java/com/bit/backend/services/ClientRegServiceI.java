package com.bit.backend.services;

import com.bit.backend.dtos.ClientRegDto;

import java.util.List;

// Create a method named "addClientReg" and declare it in ClientRegServiceI
public interface ClientRegServiceI {

    // Method to add client registration
    ClientRegDto addClientReg(ClientRegDto clientRegDto);

    // Method to retrieve client data
    List<ClientRegDto> getData();
    ClientRegDto updateClientReg(long id, ClientRegDto clientRegDto);
    ClientRegDto deleteClientReg(long id);
    //Next Step: Go to ClientRegService

}
