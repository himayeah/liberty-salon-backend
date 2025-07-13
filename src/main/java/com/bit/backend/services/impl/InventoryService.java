package com.bit.backend.services.impl;

import com.bit.backend.dtos.InventoryDto;
import com.bit.backend.entities.InventoryEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.InventoryMapper;
import com.bit.backend.repositories.InventoryRepository;
import com.bit.backend.services.InventoryServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService implements InventoryServiceI {

    private final InventoryRepository inventoryRepository;
    private final InventoryMapper inventoryMapper;

    public InventoryService(InventoryRepository inventoryRepository, InventoryMapper inventoryMapper) {
        this.inventoryRepository = inventoryRepository;
        this.inventoryMapper = inventoryMapper;
    }

    @Override
    public InventoryDto addInventory(InventoryDto inventoryDto) {
        try {
            InventoryEntity inventoryEntity = inventoryMapper.toInventoryEntity(inventoryDto);
            InventoryEntity savedItem = inventoryRepository.save(inventoryEntity);
            return inventoryMapper.toInventoryDto(savedItem);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<InventoryDto> getData() {
        try {
            List<InventoryEntity> inventoryEntityList = inventoryRepository.findAll();
            return inventoryMapper.toInventoryDtoList(inventoryEntityList);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public InventoryDto updateInventory(long id, InventoryDto inventoryDto) {
        try {
            Optional<InventoryEntity> optionalInventoryEntity = inventoryRepository.findById(id);
            if (!optionalInventoryEntity.isPresent()) {
                throw new AppException("Inventory item does not exist", HttpStatus.BAD_REQUEST);
            }
            InventoryEntity updatedEntity = inventoryMapper.toInventoryEntity(inventoryDto);
            updatedEntity.setId(id); // Important: set the existing ID
            InventoryEntity savedEntity = inventoryRepository.save(updatedEntity);
            return inventoryMapper.toInventoryDto(savedEntity);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public InventoryDto deleteInventory(long id) {
        try {
            Optional<InventoryEntity> optionalInventoryEntity = inventoryRepository.findById(id);
            if (!optionalInventoryEntity.isPresent()) {
                throw new AppException("Inventory item does not exist", HttpStatus.BAD_REQUEST);
            }

            inventoryRepository.deleteById(id);
            return inventoryMapper.toInventoryDto(optionalInventoryEntity.get());
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.BAD_REQUEST);
        }
    }
}

