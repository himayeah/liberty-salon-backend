package com.bit.backend.services.impl;

import com.bit.backend.dtos.ClientRegDto;
import com.bit.backend.entities.ClientRegEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.ClientRegMapper;
import com.bit.backend.repositories.ClientRegRepository;
import com.bit.backend.services.ClientRegServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientRegService implements ClientRegServiceI {

    private final ClientRegRepository clientRegRepository;
    private final ClientRegMapper clientRegMapper;

    public ClientRegService(ClientRegRepository clientRegRepository, ClientRegMapper clientRegMapper) {
        this.clientRegRepository = clientRegRepository;
        this.clientRegMapper = clientRegMapper;
    }

    @Override
    public ClientRegDto addClientReg(ClientRegDto clientRegDto) {

        try {
            System.out.println("In the Backend");

            //Converting DTO to Entity and Entity to DTO
            ClientRegEntity clientRegEntity = clientRegMapper.toClientRegEntity(clientRegDto);
            ClientRegEntity savedItem = clientRegRepository.save(clientRegEntity);
            ClientRegDto savedDto = clientRegMapper.toClientRegDto(savedItem);
            return savedDto;
        } catch (Exception e) {
            throw new AppException("Request failed with error:" + e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<ClientRegDto> getData() {

        try {
            List<ClientRegEntity> clientRegEntityList = clientRegRepository.findAll();
            List<ClientRegDto> clientRegDtoList = clientRegMapper.toClientRegDtoList(clientRegEntityList);
            return clientRegDtoList; // ✅ Return the actual list!
        } catch (Exception e) {
            throw new AppException("Request filled with error:" + e, HttpStatus.BAD_REQUEST);
            //error handling p2.
        }
    }

    @Override
    public ClientRegDto updateClientReg(long id, ClientRegDto clientRegDto) {

        try{
        Optional<ClientRegEntity> optionalClientRegEntity = clientRegRepository.findById(id);
        /*optional means a container that may or may not have a value. This is used to avoid null errors*/
        if (!optionalClientRegEntity.isPresent()) {
            throw new AppException("Client Reg Does Not Exist", HttpStatus.BAD_REQUEST);
        }

        ClientRegEntity newClientRegEntity = clientRegMapper.toClientRegEntity(clientRegDto);
        ClientRegEntity clientRegEntity = clientRegRepository.save(newClientRegEntity);
        ClientRegDto responseClientRegDto = clientRegMapper.toClientRegDto(clientRegEntity);
        return responseClientRegDto;
    }
        catch (Exception e) {
        throw new AppException("Request filled with error:" + e, HttpStatus.BAD_REQUEST);}
    }

    @Override
    public ClientRegDto deleteClientReg(long id) {

        try{
        Optional<ClientRegEntity> optionalClientRegEntity = clientRegRepository.findById(id);
        /*optional means a container that may or may not have a value. This is used to avoid null errors*/
        if (!optionalClientRegEntity.isPresent()) {
            throw new AppException("Client Reg Does Not Exist", HttpStatus.BAD_REQUEST);
        }

        clientRegRepository.deleteById(id);
        return clientRegMapper.toClientRegDto(optionalClientRegEntity.get());

    }
        catch (Exception e) {
        throw new AppException("Request filled with error:" + e, HttpStatus.BAD_REQUEST);}
    }

    /*Explaining the above code:
    1.This is the backend API handler for the PUT request.
    2.It finds the existing client by id.
    3.If not found, throws an error (Client Reg Does Not Exist).
    4.If found: Converts incoming DTO to entity.
    5.Sets the existing ID on the new entity.
    6.Saves the updated entity in the database.
    7.Returns the updated data as a DTO.(responseClientRegDTO)
    8.This method(updateClientReg) is called when Angular’s editData() sends the PUT request to /client-reg/{id}.
     */

    /*Refer Code 01*/

}
