package com.bit.backend.controllers;

import com.bit.backend.dtos.InventoryDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.InventoryServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryServiceI inventoryServiceI;

    public InventoryController(InventoryServiceI inventoryServiceI) {
        this.inventoryServiceI = inventoryServiceI;
    }

    @PostMapping
    public ResponseEntity<InventoryDto> addInventory(@RequestBody InventoryDto inventoryDto) throws AppException {
        try {
            InventoryDto inventoryDtoResponse = inventoryServiceI.addInventory(inventoryDto);
            return ResponseEntity.created(URI.create("/inventory/" + inventoryDtoResponse.getId()))
                    .body(inventoryDtoResponse);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<InventoryDto>> getData() {
        try {
            List<InventoryDto> inventoryDtoList = inventoryServiceI.getData();
            return ResponseEntity.ok(inventoryDtoList);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventoryDto> updateInventory(
            @PathVariable long id,
            @RequestBody InventoryDto inventoryDto) {
        try {
            InventoryDto responseInventoryDto = inventoryServiceI.updateInventory(id, inventoryDto);
            return ResponseEntity.ok(responseInventoryDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<InventoryDto> deleteInventory(@PathVariable long id) {
        try {
            InventoryDto inventoryDto = inventoryServiceI.deleteInventory(id);
            return ResponseEntity.ok(inventoryDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

