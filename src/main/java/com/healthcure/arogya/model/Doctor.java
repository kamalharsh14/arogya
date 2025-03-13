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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public List<DoctorClinicSchedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<DoctorClinicSchedule> schedules) {
        this.schedules = schedules;
    }
}
