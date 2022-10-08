package com.patrick.PatientAPIMGDB;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
public class Patient {
    @Id
    private Integer id;
    private String name;
    private String DOB;
    private String weight;
    private Gender gender;
    private String diagnosis;
    private LocalDateTime createdAt;

    private String email;
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

    public Integer getId(){
        return id;
    }

    public String getWeight(){
        return weight;
    }
}
