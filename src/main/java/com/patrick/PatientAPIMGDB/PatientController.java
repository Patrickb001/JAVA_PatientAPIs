package com.patrick.PatientAPIMGDB;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public Optional<Patient> fetchPatientById(@RequestParam(value="id") Integer value ){
        System.out.println(value);
        return patientService.getPatientById(value);
    }
    @PostMapping(consumes = {"application/json"})
    public void addPatient(@RequestBody Patient patient){
        patientService.addPatient(patient);
    }
}
