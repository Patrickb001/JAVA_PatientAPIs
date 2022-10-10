package com.patrick.PatientAPIMGDB.repository;

import com.patrick.PatientAPIMGDB.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface PatientRepository
        extends MongoRepository<Patient, String> {
    Optional<Patient> findPatientByEmail(String email);

    Optional<Patient> findPatientById(String id);

    Patient insert(Patient patient);

    Patient save(Patient patient);

    void deleteById(Integer id);

}
