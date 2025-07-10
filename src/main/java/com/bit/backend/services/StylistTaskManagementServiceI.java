package com.bit.backend.services;

import com.bit.backend.dtos.StylistTaskManagementDto;
import java.util.List;

public interface StylistTaskManagementServiceI {

    StylistTaskManagementDto addStylistTask(StylistTaskManagementDto stylistTaskManagementDto);

    List<StylistTaskManagementDto> getStylistTask();
    StylistTaskManagementDto editStylistTask(Long id, StylistTaskManagementDto stylistTaskManagementDto);
    StylistTaskManagementDto deleteStylistTask(Long id);

}
