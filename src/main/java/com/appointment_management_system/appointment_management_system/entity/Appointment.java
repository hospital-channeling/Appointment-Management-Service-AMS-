package com.appointment_management_system.appointment_management_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="`appointment_management`")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int doctor_id;
    @Column
    private int patient_id;
    @Column
    private int receptionist_id;
    @Column
    private String appDate;
    @Column
    private String start_time;
    @Column
    private String end_time;
    @Enumerated(EnumType.ORDINAL)
    private Status status;
    private enum Status{
        scheduled,canceled,completed
    }
    @Column
    private String reason;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public int getReceptionist_id() {
        return receptionist_id;
    }

    public void setReceptionist_id(int receptionist_id) {
        this.receptionist_id = receptionist_id;
    }

    public String getDate() {
        return appDate;
    }

    public void setDate(String date) {
        this.appDate = date;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
