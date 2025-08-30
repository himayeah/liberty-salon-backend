package com.bit.backend.services.impl;

import com.bit.backend.dtos.AppointmentScheduleDto;
import com.bit.backend.entities.AppointmentScheduleEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.AppointmentScheduleMapper;
import com.bit.backend.repositories.AppointmentScheduleRepository;
import com.bit.backend.services.AppointmentScheduleServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentScheduleService implements AppointmentScheduleServiceI {

    @Autowired
    private AppointmentScheduleRepository appointmentScheduleRepository;

    @Autowired
    private AppointmentScheduleMapper appointmentScheduleMapper;

    @Override
    public AppointmentScheduleDto addAppointmentSchedule(AppointmentScheduleDto appointmentScheduleDto) {
        try {
            AppointmentScheduleEntity appointmentScheduleEntity = appointmentScheduleMapper.toAppointmentScheduleEntity(appointmentScheduleDto);
            AppointmentScheduleEntity savedItem = appointmentScheduleRepository.save(appointmentScheduleEntity);
            AppointmentScheduleDto savedAppointmentScheduleDto = appointmentScheduleMapper.toAppointmentScheduleDto(savedItem);
            System.out.println("saved Successfully: " + savedAppointmentScheduleDto.getServiceType());
            return savedAppointmentScheduleDto;
        } catch (Exception e) {
            throw new AppException("Request failed with error " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<AppointmentScheduleDto> getData() {
        try {
            List<AppointmentScheduleEntity> appointmentScheduleEntityList = appointmentScheduleRepository.findAll();
            return appointmentScheduleMapper.toAppointmentScheduleDtoList(appointmentScheduleEntityList);
        } catch (Exception e) {
            throw new AppException("Request failed with error " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public AppointmentScheduleDto deleteData(long id) {
        try {
            Optional<AppointmentScheduleEntity> optionalAppointmentScheduleEntity = appointmentScheduleRepository.findById(id);

            if (!optionalAppointmentScheduleEntity.isPresent()) {
                throw new AppException("Appointment Schedule Entity does not exist", HttpStatus.BAD_REQUEST);
            }

            appointmentScheduleRepository.deleteById(id);
            return appointmentScheduleMapper.toAppointmentScheduleDto(optionalAppointmentScheduleEntity.get());
        } catch (Exception e) {
            throw new AppException("Request failed with error " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    public AppointmentScheduleDto editData(long id, AppointmentScheduleDto appointmentScheduleDto) {
        try {
            Optional<AppointmentScheduleEntity> findAppointmentScheduleEntity = appointmentScheduleRepository.findById(id);
            if (!findAppointmentScheduleEntity.isPresent()) {
                throw new AppException("Appointment Schedule does not exist", HttpStatus.BAD_REQUEST);
            }

            AppointmentScheduleEntity newAppointmentScheduleEntity = appointmentScheduleMapper.toAppointmentScheduleEntity(appointmentScheduleDto);
            newAppointmentScheduleEntity.setId(id);

            AppointmentScheduleEntity updatedEntity = appointmentScheduleRepository.save(newAppointmentScheduleEntity);
            AppointmentScheduleDto appointmentScheduleDtoRes = appointmentScheduleMapper.toAppointmentScheduleDto(updatedEntity);

            System.out.println("update Successfully: " + appointmentScheduleDtoRes.getServiceType());
            return appointmentScheduleDtoRes;
        } catch (Exception e) {
            throw new AppException("Request failed with error " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
