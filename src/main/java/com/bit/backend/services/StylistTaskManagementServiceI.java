package com.bit.backend.services;

import com.bit.backend.dtos.StylistTaskManagementDto;
import java.util.List;

public interface StylistTaskManagementServiceI {

    StylistTaskManagementDto addStylistTaskManagement(StylistTaskManagementDto stylistTaskManagementDto);

    List<StylistTaskManagementDto> getData();
    StylistTaskManagementDto updateStylistTaskManagement(long id, StylistTaskManagementDto stylistTaskManagementDto);
    StylistTaskManagementDto deleteStylistTaskManagement(long id);

}
