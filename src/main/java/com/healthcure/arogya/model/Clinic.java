package com.healthcure.arogya.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.*;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;
    @NonNull
    private String address;
    @NonNull
    private String contact;
    private String services;

    @OneToMany(mappedBy = "clinic", cascade = CascadeType.ALL)
    private List<DoctorClinicSchedule> schedules = new ArrayList<>();
}

