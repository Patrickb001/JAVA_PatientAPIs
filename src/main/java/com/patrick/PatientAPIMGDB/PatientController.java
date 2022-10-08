package com.patrick.PatientAPIMGDB;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/patients")
@AllArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    public List<Patient> fetchAllStudents(){
        return patientService.getAllPatients();
    }
    @GetMapping("id")
    public Optional<Patient> fetchStudentById(@RequestParam(value="id") Integer value ){
        System.out.println(value);
        return patientService.getPatientById(value);
    }
}
