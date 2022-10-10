package com.patrick.PatientAPIMGDB.controller;

import com.patrick.PatientAPIMGDB.model.Patient;
import com.patrick.PatientAPIMGDB.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/patients")
@AllArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    public List<Patient> fetchAllPatients(){
        return patientService.getAllPatients();
    }

    @GetMapping("id")
    public Optional<Patient> fetchPatientById(@RequestParam(value="id") String id ){
        return patientService.getPatientById(id);
    }

    @PostMapping(consumes = {"application/json"})
    public Patient addPatient(@Valid @RequestBody Patient patient){
        return patientService.addPatient(patient);
    }

    @PutMapping("id")
    public Patient updatePatient(@Valid @RequestParam(value="id") String value , @RequestBody Patient patient){

        patientService.updatePatient(patient);

        System.out.println(patient);

        return patient;
    }

    @DeleteMapping("id")
    public List<Patient> deletePatient(@RequestParam(value="id") String value){
        patientService.deletePatient(value);

        var allPatients = patientService.getAllPatients();

        return allPatients;
    }
}
