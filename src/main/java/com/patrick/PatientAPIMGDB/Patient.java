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
    private LocalDate DOB;
    private Integer weight;
    private Gender gender;
    private String diagnosis;
    private LocalDateTime createdAt;

    private String email;
    private List<String> comorbidities;

    public Patient(Integer id,
                   String name,
                   LocalDate DOB,
                   Integer weight,
                   Gender gender,
                   String diagnosis,
                   LocalDateTime createdAt,
                   String email,
                   List<String> comorbidities
    ) {
        this.id = id;
        this.name = name;
        this.DOB = DOB;
        this.weight = weight;
        this.gender = gender;
        this.diagnosis = diagnosis;
        this.comorbidities = comorbidities;
        this.email = email;
        this.createdAt = createdAt;
    }

    public Integer getId(){
        return id;
    }
}
