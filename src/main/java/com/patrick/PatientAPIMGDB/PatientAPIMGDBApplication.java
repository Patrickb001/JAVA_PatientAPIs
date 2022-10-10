package com.patrick.PatientAPIMGDB;

import com.patrick.PatientAPIMGDB.model.Gender;
import com.patrick.PatientAPIMGDB.model.Patient;
import com.patrick.PatientAPIMGDB.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;


import java.time.LocalDateTime;
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
			Patient patient = new Patient("Jamila Ahmed",
					"1974, Month.APRIL, 10",
					"124", Gender.FEMALE, "Acute Kidney Failure",  "jahmed@gmail.com", List.of("Heart Failure", "Fracture Ankle"));



			Patient patient2 = new Patient("John Adams",
					"1985, 12, 1",
					"284", Gender.MALE, "Choledocolithiasis",  "adams.john@yahoo.com", List.of("Hepatitis", "High Cholesterol", "Diabetes"));



			Patient patient3 = new Patient("Chris Smith",
					"1990, 11, 21",
					"184", Gender.MALE, "Myocarditis",  "chrissmith12@gmail.com", List.of(""));

			patient.setId(Counter.getId());
			patient2.setId(Counter.getId());
			patient3.setId(Counter.getId());

			patient.setCreatedAt(LocalDateTime.now());
			patient2.setCreatedAt(LocalDateTime.now());
			patient3.setCreatedAt(LocalDateTime.now());


//			Adds patients to mongodb database on initial load
//			repository.findPatientByEmail("jahmed@gmail.com")
//					.ifPresentOrElse(p -> System.out.println(p + " already exists"), () -> {
//						System.out.println("Inserting patient " + patient);
//						repository.insert(patient);
//						repository.insert(patient2);
//						repository.insert(patient3);
//					});
		};
	}

}
