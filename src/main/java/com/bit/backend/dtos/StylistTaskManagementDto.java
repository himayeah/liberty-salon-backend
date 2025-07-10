package com.bit.backend.dtos;

public class StylistTaskManagementDto {

    private long id;
    private String stylistName;
    private String serviceType;
    private String date;
    private String startTime;
    private String endTime;
    private String status;

    public StylistTaskManagementDto() {
    }

    public StylistTaskManagementDto(long id, String stylistName, String serviceType, String date, String startTime, String endTime, String status) {
        this.id = id;
        this.stylistName = stylistName;
        this.serviceType = serviceType;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStylistName() {
        return stylistName;
    }

    public void setStylistName(String stylistName) {
        this.stylistName = stylistName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
