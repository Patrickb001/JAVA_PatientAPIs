package com.patrick.PatientAPIMGDB;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
    public Optional<Patient> getPatientById(Integer id) {
        return patientRepository.findPatientById(id);
    }
}
