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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public List<DoctorClinicSchedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<DoctorClinicSchedule> schedules) {
        this.schedules = schedules;
    }
}

