package ar.edu.ues21.algarrobo.admissioneventservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AdmissionEventServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdmissionEventServiceApplication.class, args);
	}

}
