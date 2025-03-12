package com.healthcure.arogya.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
public class DoctorClinicSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
    private boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;

}
