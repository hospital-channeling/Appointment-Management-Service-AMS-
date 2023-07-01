package com.appointment_management_system.appointment_management_system.controller;

import com.appointment_management_system.appointment_management_system.entity.Appointment;
import com.appointment_management_system.appointment_management_system.repository.IAppointmentRepo;
import com.appointment_management_system.appointment_management_system.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping(value = "/api/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/appointmentgetbyid/{id}")
    public Appointment getAppointmentByID(@PathVariable int id){
        return appointmentService.getAppointmentByID(id);
    }

    @GetMapping("/appointmentget")
    public List<Appointment> getAllAppointment(){
        return appointmentService.getAllAppointment();
    }
    @PostMapping("/appointmentcreate")
    public Appointment createAppointment(@RequestBody Appointment appointment, @PathVariable String doctorName, @PathVariable String paitentName){

        return appointmentService.createAppointment(appointment,doctorName,paitentName);
    }
    @PutMapping(value = "/appointmentupdate/{id}")
    public Appointment updateAppointment(@PathVariable int id,@RequestBody Appointment appointment){
        return  appointmentService.updateAppointment(id,appointment);
    }

    @DeleteMapping("/appointmentdelete/{id}")
    public void deleteAppointment(@PathVariable int id){
        appointmentService.deleteAppointment(id);
    }
}
