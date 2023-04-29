package com.appointment_management_system.appointment_management_system.controller;

import com.appointment_management_system.appointment_management_system.entity.Appointment;
import com.appointment_management_system.appointment_management_system.repository.IAppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin
public class AppointmentController {

    @Autowired
    private IAppointmentRepo appointmentRepo;

    @GetMapping(value = "/")
    public String getWelcome(){
        return "Welcome";
    }

    @GetMapping("/appointmnet")
    public List<Appointment> getAppointment(){
        return appointmentRepo.findAll();
    }

    @PostMapping("/save")
    public Appointment save(@RequestBody Appointment appointment){

        return appointmentRepo.save(appointment);
    }
}
