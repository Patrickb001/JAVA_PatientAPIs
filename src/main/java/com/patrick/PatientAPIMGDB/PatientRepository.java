package com.patrick.PatientAPIMGDB;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;


public interface PatientRepository
        extends MongoRepository<Patient, String> {
    Optional<Patient> findPatientByEmail(String email);

    Optional<Patient> findPatientById(Integer id);

    Patient insert(Patient patient);

    Patient save(Patient patient);

}
