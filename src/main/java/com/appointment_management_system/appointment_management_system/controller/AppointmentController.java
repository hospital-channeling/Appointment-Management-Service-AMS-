package com.appointment_management_system.appointment_management_system.controller;

import com.appointment_management_system.appointment_management_system.entity.Appointment;
import com.appointment_management_system.appointment_management_system.entity.DoctorAvailabilityResponse;
import com.appointment_management_system.appointment_management_system.service.AppointmentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping(value = "/api/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentServiceImp appointmentService;
    private RestTemplate restTemplate;

    @GetMapping("/appointmentgetbyid/{id}")
    public Appointment getAppointmentByID(@PathVariable int id){
        return appointmentService.getAppointmentByID(id);
    }

    @GetMapping("/appointmentget")
    public List<Appointment> getAllAppointment(){
        return appointmentService.getAllAppointment();
    }

    @PostMapping("/appointmentcreate")
    public Appointment createAppointment(@RequestBody Appointment appointment){
        appointment.setAppStatus("Not Confirmed");
        return appointmentService.createAppointment(appointment);
    }
    @PostMapping("/appointmentcreatecheck")
    public Appointment createAppointmentCheck(@RequestBody Appointment appointment) {
        //Check is the doctor is available for the requested date and time slot
        DoctorAvailabilityResponse availabilityResponse = checkDoctorAvailability(appointment.getDoctorName(), appointment.getAppDate());
        if (availabilityResponse.isAvailable()) {
            List<String> availableTimeSlots = availabilityResponse.getTimeSlots();
            System.out.println("Available Time Slots: " + availableTimeSlots);
            appointment.setAppStatus("Not Confirmed");
            return appointmentService.createAppointment(appointment);
        }else{
            System.out.println("Doctor is not available");
        }
        return null;
    }

    @PutMapping(value = "/appointmentupdate/{id}")
    public Appointment updateAppointment(@PathVariable int id,@RequestBody Appointment appointment){
        return  appointmentService.updateAppointment(id,appointment);
    }

    @DeleteMapping("/appointmentdelete/{id}")
    public void deleteAppointment(@PathVariable int id){
        appointmentService.deleteAppointment(id);
    }

    private DoctorAvailabilityResponse checkDoctorAvailability(String doctorName, String appDate) {
        String url = "http://doctor-service-url/availability?doctorName=" + doctorName + "&date=" + appDate;
        return restTemplate.getForObject(url,DoctorAvailabilityResponse.class);
    }
}
