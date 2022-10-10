package com.patrick.PatientAPIMGDB.service;

import com.patrick.PatientAPIMGDB.repository.PatientRepository;
import com.patrick.PatientAPIMGDB.model.Patient;
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

    public Optional<Patient> getPatientById(String id) {
        return patientRepository.findPatientById(id);
    }

    public Patient addPatient(Patient patient){
        return patientRepository.insert(patient);
    }
    public Patient updatePatient(Patient patient){
        return patientRepository.save(patient);
    }

    public void deletePatient(String id){
        patientRepository.deleteById(id);
    }

}
