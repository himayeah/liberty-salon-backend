package com.bit.backend.mappers;
import com.bit.backend.dtos.StylistTaskManagementDto;
import com.bit.backend.entities.StylistTaskManagementEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StylistTaskManagementMapper {

    StylistTaskManagementDto toStylistTaskManagementDto(StylistTaskManagementEntity stylistTaskManagementEntity);
    StylistTaskManagementEntity toStylistTaskManagementEntity(StylistTaskManagementDto stylistTaskManagementDto);
    List<StylistTaskManagementDto> toStylistTaskManagementDtoList(List<StylistTaskManagementEntity> stylistTaskManagementEntityList);

}
