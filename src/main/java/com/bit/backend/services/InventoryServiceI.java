package com.bit.backend.services;

import com.bit.backend.dtos.InventoryDto;
import java.util.List;

public interface InventoryServiceI {

    InventoryDto addInventory(InventoryDto inventoryDto);

    List<InventoryDto> getData();

    InventoryDto updateInventory(long id, InventoryDto inventoryDto);

    InventoryDto deleteInventory(long id);

}
