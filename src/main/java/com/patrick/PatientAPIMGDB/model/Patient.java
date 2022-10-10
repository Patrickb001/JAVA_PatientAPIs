package com.patrick.PatientAPIMGDB.model;

import com.patrick.PatientAPIMGDB.model.Gender;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
public class Patient {
    @Id
    private String id;

    @NotEmpty(message = "Name is required")
    private String name;

    @NotEmpty(message = "Date of Birth is required")
    private String DOB;

    @NotEmpty(message = "Weight is required")
    private String weight;

    @NotEmpty(message = "Gender is required")
    private Gender gender;

    @NotEmpty(message = "Diagnosis is required")
    private String diagnosis;
    private LocalDateTime createdAt;

    private String email;

    @NotEmpty(message = "comorbidities is required")
    private List<String> comorbidities;

    public Patient() {
    }

    public Patient(String name, String DOB, String weight, Gender gender, String diagnosis, String email, List<String> comorbidities) {
        this.name = name;
        this.DOB = DOB;
        this.weight = weight;
        this.gender = gender;
        this.diagnosis = diagnosis;
        this.email = email;
        this.comorbidities = comorbidities;
    }

    public String getId(){
        return id;
    }

    public String getWeight(){
        return weight;
    }
}
