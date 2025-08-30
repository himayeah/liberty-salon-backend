package com.bit.backend.repositories;

import com.bit.backend.entities.StylistTaskManagementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StylistTaskManagementRepository extends JpaRepository<StylistTaskManagementEntity, Long> {
}
