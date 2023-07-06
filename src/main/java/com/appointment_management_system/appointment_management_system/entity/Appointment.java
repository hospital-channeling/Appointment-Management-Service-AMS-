package com.appointment_management_system.appointment_management_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="`Appointment_management`")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id",nullable = false)
    private int appointment_id;
    @Column(name = "doctorName",nullable = false)
    private String doctorName;
    @Column(name = "patientName",nullable = false)
    private String patientName;
    @Column(name = "appDate", nullable = false)
    private String appDate;
    @Column(name = "appStatus",nullable = false)
    private String appStatus;

    public int getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(int appointment_id) {
        this.appointment_id = appointment_id;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getAppDate() {
        return appDate;
    }

    public void setAppDate(String appDate) {
        this.appDate = appDate;
    }

    public String getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(String appStatus) {
        this.appStatus = appStatus;
    }

}