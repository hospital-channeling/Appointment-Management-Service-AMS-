package com.appointment_management_system.appointment_management_system.service;

import com.appointment_management_system.appointment_management_system.entity.Appointment;

import java.util.List;

public interface AppointmentServiceImp {

    Appointment createAppointment(Appointment appointment);
    void deleteAppointment(int id);

    Appointment updateAppointment(int id,Appointment appointment);

    Appointment getAppointmentByID(int id);

    List<Appointment> getAllAppointment();
}
