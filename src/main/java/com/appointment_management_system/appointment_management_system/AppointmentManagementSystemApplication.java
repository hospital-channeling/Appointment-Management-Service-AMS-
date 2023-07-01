package com.appointment_management_system.appointment_management_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(AppConfig.class)
public class AppointmentManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppointmentManagementSystemApplication.class, args);
	}

}
