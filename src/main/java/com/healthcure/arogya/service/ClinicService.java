package com.healthcure.arogya.service;

import com.healthcure.arogya.dto.ClinicDTO;
import com.healthcure.arogya.model.Clinic;
import com.healthcure.arogya.repository.ClinicRepository;
import com.healthcure.arogya.model.DoctorClinicSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClinicService {

    @Autowired
    private ClinicRepository clinicRepository;

    public List<ClinicDTO> getAllClinics() {
        return clinicRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<ClinicDTO> getClinicById(Long id) {
        return clinicRepository.findById(id).map(this::convertToDto);
    }

    public Clinic createClinic(Clinic clinic) {
        return clinicRepository.save(clinic);
    }

    public Optional<Clinic> updateClinic(Long id, Clinic clinicDetails) {
        return clinicRepository.findById(id).map(clinic -> {
            clinic.setName(clinicDetails.getName());
            clinic.setAddress(clinicDetails.getAddress());
            clinic.setContact(clinicDetails.getContact());
            clinic.setServices(clinicDetails.getServices());
            return clinicRepository.save(clinic);
        });
    }

    public void deleteClinic(Long id) {
        clinicRepository.deleteById(id);
    }

    private ClinicDTO convertToDto(Clinic clinic) {
        ClinicDTO dto = new ClinicDTO();
        dto.setId(clinic.getId());
        dto.setName(clinic.getName());
        dto.setAddress(clinic.getAddress());
        dto.setContact(clinic.getContact());
        dto.setServices(clinic.getServices());
        dto.setDoctorCount(clinic.getSchedules() != null ? clinic.getSchedules().stream()
                .map(DoctorClinicSchedule::getDoctor)
                .distinct()
                .count() : 0);
        return dto;
    }
}

