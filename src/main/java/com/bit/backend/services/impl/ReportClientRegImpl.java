package com.bit.backend.services.impl;

import com.bit.backend.dtos.ClientRegDto;
import com.bit.backend.entities.ClientRegEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.ClientRegMapper;
import com.bit.backend.repositories.ClientRegRepository;
import com.bit.backend.services.ReportClientRegService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportClientRegImpl implements ReportClientRegService {

    private final ClientRegRepository clientRegRepository;
    private final ClientRegMapper clientRegMapper;

    public ReportClientRegImpl(ClientRegRepository clientRegRepository, ClientRegMapper clientRegMapper) {
        this.clientRegRepository = clientRegRepository;
        this.clientRegMapper = clientRegMapper;
    }

    @Override
    public List<ClientRegDto> getAllClientsData() {
        try {
            List<ClientRegEntity> clientRegEntityList = clientRegRepository.findAll();
            List<ClientRegDto> clientRegDtoList = clientRegMapper.toClientRegDtoList(clientRegEntityList);
            return clientRegDtoList;
        }
        catch (Exception e) {
            throw new AppException("Request failed with error" + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
