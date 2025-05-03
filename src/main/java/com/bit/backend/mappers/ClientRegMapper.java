package com.bit.backend.mappers;

import com.bit.backend.dtos.ClientRegDto;
import com.bit.backend.entities.ClientRegEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientRegMapper {

    ClientRegDto toClientRegDto(ClientRegEntity clientRegEntity);
    ClientRegEntity toClientRegEntity(ClientRegDto clientRegDto);
    List <ClientRegDto> toClientRegDtoList(List<ClientRegEntity> clientRegEntityList);

}
