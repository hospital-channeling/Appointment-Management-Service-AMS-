package com.appointment_management_system.appointment_management_system.repository;

import com.appointment_management_system.appointment_management_system.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IAppointmentRepo extends JpaRepository<Appointment,Integer> {
}
