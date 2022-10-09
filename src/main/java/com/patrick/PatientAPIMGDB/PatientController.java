package com.patrick.PatientAPIMGDB;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
        return patientService.getPatientById(value);
    }
    @PostMapping(consumes = {"application/json"})
    public List<Patient> addPatient(@RequestBody Patient patient){
        var allPatients = patientService.getAllPatients();

        patientService.getPatientById(patient.getId())
                .ifPresentOrElse(p -> System.out.println(p + " already exists"), () -> {
						System.out.println("Inserting patient " + patient);
                        Counter.setId(allPatients.size() + 1);
                        Integer newId = Counter.getId();

                        patient.setId(newId);
                        patient.setCreatedAt(LocalDateTime.now());
                        patientService.addPatient(patient);
					});
        return patientService.getAllPatients();
    }
    @PutMapping("id")
    public Patient updatePatient(@RequestParam(value="id") Integer value , @RequestBody Patient patient){
        var foundPatient = patientService.getPatientById(value).get();

        if (patient.getName() != null)
            foundPatient.setName(patient.getName());

        if (patient.getWeight() != null)
            foundPatient.setWeight(patient.getWeight());

        if (patient.getDiagnosis() != null)
            foundPatient.setDiagnosis(patient.getDiagnosis());

        if (patient.getGender() != null)
            foundPatient.setGender(patient.getGender());

        if (patient.getEmail() != null)
            foundPatient.setEmail(patient.getEmail());

        if (patient.getComorbidities() != null)
            foundPatient.setComorbidities(patient.getComorbidities());

        patientService.updatePatient(foundPatient);

        System.out.println(foundPatient);

        return foundPatient;
    }

    @DeleteMapping("id")
    public List<Patient> deletePatient(@RequestParam(value="id") Integer value){
        patientService.deletePatient(value);

        var allPatients = patientService.getAllPatients();

        return allPatients;
    }
}
