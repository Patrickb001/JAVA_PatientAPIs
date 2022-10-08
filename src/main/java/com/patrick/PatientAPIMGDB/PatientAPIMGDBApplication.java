package com.patrick.PatientAPIMGDB;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class PatientAPIMGDBApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientAPIMGDBApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(
			PatientRepository repository, MongoTemplate mongoTemplate) {
		return args -> {
			Patient patient = new Patient(Counter.getId(),"Jamila Ahmed",
					LocalDate.of(1974, Month.APRIL, 10),
					124, Gender.FEMALE, "Acute Kidney Failure", LocalDateTime.now(), "jahmed@gmail.com", List.of("Heart Failure", "Fracture Ankle"));
			Patient patient2 = new Patient(Counter.getId(),"John Adams",
					LocalDate.of(1985, Month.DECEMBER, 1),
					284, Gender.MALE, "Choledocolithiasis", LocalDateTime.now(), "adams.john@yahoo.com", List.of("Hepatitis", "High Cholesterol", "Diabetes"));
			Patient patient3 = new Patient(Counter.getId(),"Chris Smith",
					LocalDate.of(1990, Month.NOVEMBER, 21),
					184, Gender.MALE, "Myocarditis", LocalDateTime.now(), "chrissmith12@gmail.com", List.of(""));

			repository.findPatientByEmail("jahmed@gmail.com")
					.ifPresentOrElse(p -> System.out.println(p + " already exists"), () -> {
						System.out.println("Inserting patient " + patient);
						repository.insert(patient);
						repository.insert(patient2);
						repository.insert(patient3);
					});
		};
	}

}
