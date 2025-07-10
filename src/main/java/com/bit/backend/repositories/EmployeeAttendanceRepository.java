package com.bit.backend.repositories;

import com.bit.backend.entities.EmployeeAttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// Mention the entity class and the type of its primary key (Long)
public interface EmployeeAttendanceRepository extends JpaRepository<EmployeeAttendanceEntity, Long> {
}
