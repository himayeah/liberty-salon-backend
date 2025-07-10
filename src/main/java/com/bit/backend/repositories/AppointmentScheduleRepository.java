package com.bit.backend.repositories;

import com.bit.backend.entities.AppointmentScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// Mention the entity (AppointmentScheduleEntity) and its ID type (Long)
public interface AppointmentScheduleRepository extends JpaRepository<AppointmentScheduleEntity, Long> {
}

