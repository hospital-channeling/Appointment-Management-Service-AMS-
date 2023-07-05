package com.appointment_management_system.appointment_management_system.service;

import com.appointment_management_system.appointment_management_system.entity.Appointment;
import com.appointment_management_system.appointment_management_system.entity.DoctorAvailabilityResponse;
import com.appointment_management_system.appointment_management_system.repository.IAppointmentRepo;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.persistence.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AppointmentService implements AppointmentServiceImp {

    @Autowired
    private IAppointmentRepo appointmentRepo;
    private EntityManager entityManager;

    @Override
    public Appointment createAppointment(Appointment appointment) {
        appointment.setAppStatus("Not Confirmed");
        return appointmentRepo.save(appointment);
    }

    @Override
    public void deleteAppointment(int id) {
        appointmentRepo.deleteById(id);
    }

    @Override
    public Appointment updateAppointment(int id, Appointment appointment) {
        Optional<Appointment> exsistingAppointment = appointmentRepo.findById(id);
        Appointment updatedAppointment = exsistingAppointment.get();
        if (exsistingAppointment.isPresent()) {
            updatedAppointment.setPatientName(appointment.getPatientName());
            updatedAppointment.setDoctorName(appointment.getDoctorName());
            updatedAppointment.setAppDate(appointment.getAppDate());
            updatedAppointment.setTimeSlots(appointment.getTimeSlots());
            updatedAppointment.setAppStatus(appointment.getAppStatus());
        } else {
            System.out.println("No appointment found");
        }
        return appointmentRepo.save(updatedAppointment);
    }

    @Override
    public List<Appointment> getAllAppointment() {

        return (List<Appointment>) appointmentRepo.findAll();
    }

    @Override
    public Appointment getAppointmentByID(int id) {
        if (appointmentRepo.findById(id).isPresent()) {
            return appointmentRepo.findById(id).get();
        } else {
            System.out.println("User Not Found" + id);
        }
        return null;
    }

}

