package com.appointment_management_system.appointment_management_system.entity;

import java.util.List;

public class DoctorAvailabilityResponse {

    private boolean available;
    private List<String> timeSlots;
    private String appDate;
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public List<String> getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(List<String> timeSlots) {
        this.timeSlots = timeSlots;
    }

    public String getAppDate() {
        return appDate;
    }

    public void setAppDate(String appDate) {
        this.appDate = appDate;
    }

}
