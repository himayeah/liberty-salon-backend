package com.bit.backend.services.impl;

import com.bit.backend.dtos.ClientRegDto;
import com.bit.backend.dtos.StylistTaskManagementDto;
import com.bit.backend.entities.ClientRegEntity;
import com.bit.backend.entities.StylistTaskManagementEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.StylistTaskManagementMapper;
import com.bit.backend.repositories.StylistTaskManagementRepository;
import com.bit.backend.services.StylistTaskManagementServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class StylistTaskManagementService implements StylistTaskManagementServiceI {

    private final StylistTaskManagementRepository stylistTaskManagementRepository;
    private final StylistTaskManagementMapper stylistTaskManagementMapper;

    public StylistTaskManagementService(StylistTaskManagementRepository stylistTaskManagementRepository, StylistTaskManagementMapper stylistTaskManagementMapper) {
        this.stylistTaskManagementRepository = stylistTaskManagementRepository;
        this.stylistTaskManagementMapper = stylistTaskManagementMapper;
    }

    @Override
    public StylistTaskManagementDto addStylistTaskManagement(StylistTaskManagementDto stylistTaskManagementDto) {

        try {
            System.out.println("In the Backend");
            StylistTaskManagementEntity stylistTaskManagementEntity = stylistTaskManagementMapper.toStylistTaskManagementEntity(stylistTaskManagementDto);
            StylistTaskManagementEntity savedItem = stylistTaskManagementRepository.save(stylistTaskManagementEntity);
            StylistTaskManagementDto savedDto = stylistTaskManagementMapper.toStylistTaskManagementDto(savedItem);
            return savedDto;
        } catch (Exception e) {
            throw new AppException("Request filled with error:" + e, HttpStatus.BAD_REQUEST);
        }

        }

    @Override
    public List<StylistTaskManagementDto> getData() {

        try {
            List<StylistTaskManagementEntity> stylistTaskManagementEntityList = stylistTaskManagementRepository.findAll();
            List<StylistTaskManagementDto> stylistTaskManagementDtoList = stylistTaskManagementMapper.toStylistTaskManagementDtoList(stylistTaskManagementEntityList);
            return stylistTaskManagementDtoList;
        } catch (Exception e) {
            throw new AppException("Request filled with error:" + e, HttpStatus.BAD_REQUEST);
        }
        }

    @Override
    public StylistTaskManagementDto updateStylistTaskManagement(long id, StylistTaskManagementDto stylistTaskManagementDto) {

        try{
            Optional<StylistTaskManagementEntity> optionalStylistTaskManagementEntity = stylistTaskManagementRepository.findById(id);
            if (!optionalStylistTaskManagementEntity.isPresent()) {
                throw new AppException("Client Reg Does Not Exist", HttpStatus.BAD_REQUEST);
            }
            StylistTaskManagementEntity newStylistTaskManagementEntity = stylistTaskManagementMapper.toStylistTaskManagementEntity(stylistTaskManagementDto);
            StylistTaskManagementEntity stylistTaskManagementEntity = stylistTaskManagementRepository.save(newStylistTaskManagementEntity);
            StylistTaskManagementDto responseStylistTaskManagementDto = stylistTaskManagementMapper.toStylistTaskManagementDto(stylistTaskManagementEntity);
            return responseStylistTaskManagementDto;
        }
            catch (Exception e) {
            throw new AppException("Request filled with error:" + e, HttpStatus.BAD_REQUEST);}

        }

    @Override
    public StylistTaskManagementDto deleteStylistTaskManagement(long id) {
        try{
            Optional<StylistTaskManagementEntity> optionalStylistTaskManagementEntity = stylistTaskManagementRepository.findById(id);
            if (!optionalStylistTaskManagementEntity.isPresent()) {
                throw new AppException("Client Reg Does Not Exist", HttpStatus.BAD_REQUEST);
            }

            stylistTaskManagementRepository.deleteById(id);
            return stylistTaskManagementMapper.toStylistTaskManagementDto(optionalStylistTaskManagementEntity.get());
        }
        catch (Exception e) {
            throw new AppException("Request filled with error:" + e, HttpStatus.BAD_REQUEST);}
        }
    }
    
