package com.bit.backend.repositories;

import com.bit.backend.entities.InventoryEntity;
import com.bit.backend.entities.StylistTaskManagementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<InventoryEntity, Long> {
}
