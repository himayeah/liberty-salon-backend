package com.bit.backend.services.impl;

import com.bit.backend.dtos.AppointmentScheduleDto;
import com.bit.backend.entities.AppointmentScheduleEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.AppointmentScheduleMapper;
import com.bit.backend.repositories.AppointmentScheduleRepository;
import com.bit.backend.services.AppointmentScheduleServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentScheduleService implements AppointmentScheduleServiceI {

    private final AppointmentScheduleRepository appointmentScheduleRepository;
    private final AppointmentScheduleMapper appointmentScheduleMapper;

    public AppointmentScheduleService(AppointmentScheduleRepository appointmentScheduleRepository, AppointmentScheduleMapper appointmentScheduleMapper) {
        this.appointmentScheduleRepository = appointmentScheduleRepository;
        this.appointmentScheduleMapper = appointmentScheduleMapper;
    }

    @Override
    public AppointmentScheduleDto addAppointmentScheduleEntity(AppointmentScheduleDto appointmentScheduleDto) {
        try {
            System.out.println("*** backend - addAppointmentScheduleEntity ***");

            AppointmentScheduleEntity entity = appointmentScheduleMapper.toAppointmentScheduleEntity(appointmentScheduleDto);
            AppointmentScheduleEntity savedEntity = appointmentScheduleRepository.save(entity);
            return appointmentScheduleMapper.toAppointmentScheduleDto(savedEntity);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<AppointmentScheduleDto> getData() {
        try {
            List<AppointmentScheduleEntity> entityList = appointmentScheduleRepository.findAll();
            return appointmentScheduleMapper.toAppointmentScheduleDtoList(entityList);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public AppointmentScheduleDto updateAppointmentScheduleEntity(long id, AppointmentScheduleDto appointmentScheduleDto) {
        try {
            Optional<AppointmentScheduleEntity> optionalEntity = appointmentScheduleRepository.findById(id);
            if (!optionalEntity.isPresent()) {
                throw new AppException("Appointment schedule does not exist", HttpStatus.BAD_REQUEST);
            }

            AppointmentScheduleEntity newEntity = appointmentScheduleMapper.toAppointmentScheduleEntity(appointmentScheduleDto);
            newEntity.setId(id); // ensure the ID is set to update existing record

            AppointmentScheduleEntity savedEntity = appointmentScheduleRepository.save(newEntity);
            return appointmentScheduleMapper.toAppointmentScheduleDto(savedEntity);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public AppointmentScheduleDto deleteAppointmentScheduleEntity(long id) {
        try {
            Optional<AppointmentScheduleEntity> optionalEntity = appointmentScheduleRepository.findById(id);
            if (!optionalEntity.isPresent()) {
                throw new AppException("Appointment schedule does not exist", HttpStatus.BAD_REQUEST);
            }

            appointmentScheduleRepository.deleteById(id);
            return appointmentScheduleMapper.toAppointmentScheduleDto(optionalEntity.get());
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.BAD_REQUEST);
        }
    }
}
