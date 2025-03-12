package com.healthcure.arogya.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String specialization;

    private String contactInfo;
    private int experience;
    private String languages;
    private Double rating;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<DoctorClinicSchedule> schedules = new ArrayList<>();
}
