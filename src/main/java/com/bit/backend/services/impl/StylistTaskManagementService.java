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
    public StylistTaskManagementDto addStylistTask(StylistTaskManagementDto stylistTaskManagementDto) {
        try {
            StylistTaskManagementEntity stylistTaskManagementEntity = stylistTaskManagementMapper.toStylistTaskManagementEntity(stylistTaskManagementDto);
            StylistTaskManagementEntity savedItem = stylistTaskManagementRepository.save(stylistTaskManagementEntity);
            StylistTaskManagementDto savedDto = stylistTaskManagementMapper.toStylistTaskManagementDto(savedItem);
            System.out.println("Saved Successfully: "+ savedDto.getStylistName());
            return savedDto;
        } catch (Exception e) {
            throw new AppException("Request filled with error:" + e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<StylistTaskManagementDto> getStylistTask() {
        try {
            List<StylistTaskManagementEntity> stylistTaskManagementEntityList = stylistTaskManagementRepository.findAll();
            List<StylistTaskManagementDto> stylistTaskManagementDtoList = stylistTaskManagementMapper.toStylistTaskManagementDtoList(stylistTaskManagementEntityList);
            return stylistTaskManagementDtoList;
        } catch (Exception e) {
            throw new AppException("Request filled with error:" + e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public StylistTaskManagementDto editStylistTask(Long id, StylistTaskManagementDto stylistTaskManagementDto) {

        try{
            Optional<StylistTaskManagementEntity> findStylistTaskManagementEntity = stylistTaskManagementRepository.findById(id);
            if (!findStylistTaskManagementEntity.isPresent()) {
                throw new AppException("Client Reg Does Not Exist", HttpStatus.BAD_REQUEST);
            }
            StylistTaskManagementEntity newStylistTaskManagementEntity = stylistTaskManagementMapper.toStylistTaskManagementEntity(stylistTaskManagementDto);
            newStylistTaskManagementEntity.setId(id);
            StylistTaskManagementEntity stylistTaskManagementEntity = stylistTaskManagementRepository.save(newStylistTaskManagementEntity);
            StylistTaskManagementDto responseStylistTaskManagementDto = stylistTaskManagementMapper.toStylistTaskManagementDto(stylistTaskManagementEntity);
            return responseStylistTaskManagementDto;
        }
            catch (Exception e) {
            throw new AppException("Request filled with error:" + e, HttpStatus.BAD_REQUEST);}

        }

    @Override
    public StylistTaskManagementDto deleteStylistTask(Long id) {
        try{
            Optional<StylistTaskManagementEntity> findStylistTaskManagementEntity = stylistTaskManagementRepository.findById(id);
            if (!findStylistTaskManagementEntity.isPresent()) {
                throw new AppException("Client Reg Does Not Exist", HttpStatus.BAD_REQUEST);
            }

            stylistTaskManagementRepository.deleteById(id);
            return stylistTaskManagementMapper.toStylistTaskManagementDto(findStylistTaskManagementEntity.get());
        }
        catch (Exception e) {
            throw new AppException("Request filled with error:" + e, HttpStatus.BAD_REQUEST);}
        }
    }
    
