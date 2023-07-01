package com.appointment_management_system.appointment_management_system.service;

import com.appointment_management_system.appointment_management_system.entity.Appointment;
import com.appointment_management_system.appointment_management_system.repository.IAppointmentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AppointmentService implements AppointmentServiceImp{

    private static  final String DOCTOR_SERVICE_URL = "http://doctor-service/api/doctors/";
    private static  final String PAITENT_SERVICE_URL = "http://paitent-service/api/paitents/";

    @Autowired
    private IAppointmentRepo appointmentRepo;

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public Appointment createAppointment(Appointment appointment , String doctorName, String paitentName) {
        ResponseEntity<Integer> response1=restTemplate.exchange(
                DOCTOR_SERVICE_URL+"/{doctorname}",
                HttpMethod.GET,
                null,
                Integer.class,
                doctorName
        );
        ResponseEntity<Integer> response2=restTemplate.exchange(
                PAITENT_SERVICE_URL+"/{patientname}",
                HttpMethod.GET,
                null,
                Integer.class,
                paitentName
        );

        if(response1.getStatusCode() == HttpStatus.OK ||response2.getStatusCode() == HttpStatus.OK ){
            int doctorID = response1.getBody();
            appointment.setDoctor_id(doctorID);
            int patientID = response2.getBody();
            appointment.setPatient_id(patientID);
        }else {
            System.out.println("Doctor or Patient is not available");
        }
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
        if(exsistingAppointment.isPresent()){
            updatedAppointment.setPatient_id(appointment.getPatient_id());
            updatedAppointment.setDoctor_id(appointment.getDoctor_id());
            updatedAppointment.setAppDate(appointment.getAppDate());
            updatedAppointment.setStart_time(appointment.getStart_time());
            updatedAppointment.setEnd_time(appointment.getEnd_time());
            updatedAppointment.setStatus(appointment.getStatus());
        }else {

        }
        return appointmentRepo.save(updatedAppointment);
    }

    @Override
    public List<Appointment> getAllAppointment() {

        return (List<Appointment>) appointmentRepo.findAll();
    }

    @Override
    public Appointment getAppointmentByID(int id) {
        if(appointmentRepo.findById(id).isPresent()){
            return appointmentRepo.findById(id).get();
        }else{
            System.out.println("User Not Found" + id);
        }
        return null;
    }
}
