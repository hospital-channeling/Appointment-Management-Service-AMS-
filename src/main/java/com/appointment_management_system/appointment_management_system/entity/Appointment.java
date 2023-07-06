package com.appointment_management_system.appointment_management_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="`appointment_management`")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id",nullable = false)
    private int appointment_id;
    @Column(name = "doctor_name",nullable = false)
    private String doctor_name;
    @Column(name = "patient_name",nullable = false)
    private String patient_name;
    @Column(name = "patient_id", nullable = false)
    private int patient_id;
    @Column(name = "app_date", nullable = false)
    private String app_date;
    @Column(name = "app_status",nullable = false)
    private String app_status;

    public int getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(int appointment_id) {
        this.appointment_id = appointment_id;
    }

    public String getDoctorName() {
        return doctor_name;
    }

    public void setDoctorName(String doctorName) {
        this.doctor_name = doctorName;
    }

    public String getPatientName() {
        return patient_name;
    }

    public void setPatientName(String patientName) {
        this.patient_name = patientName;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }
    public String getAppDate() {
        return app_date;
    }

    public void setAppDate(String appDate) {
        this.app_date = appDate;
    }

    public String getAppStatus() {
        return app_status;
    }

    public void setAppStatus(String appStatus) {
        this.app_status = appStatus;
    }

}