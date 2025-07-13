package com.bit.backend.mappers;

import com.bit.backend.dtos.InventoryDto;
import com.bit.backend.entities.InventoryEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InventoryMapper {

    InventoryDto toInventoryDto(InventoryEntity inventoryEntity);
    InventoryEntity toInventoryEntity(InventoryDto inventoryDto);
    List<InventoryDto> toInventoryDtoList(List<InventoryEntity> inventoryEntityList);

}
