package com.healthcure.arogya.dto;

public class ClinicDTO {
    private Long id;
    private String name;
    private String address;
    private String contact;
    private String services;
    private long doctorCount;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public String getServices() { return services; }
    public void setServices(String services) { this.services = services; }

    public long getDoctorCount() { return doctorCount; }
    public void setDoctorCount(long doctorCount) { this.doctorCount = doctorCount; }
}

