package com.healthcure.arogya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcure.arogya.repository.*;
import com.healthcure.arogya.model.*;
import com.healthcure.arogya.dto.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DoctorClinicScheduleRepository scheduleRepository;

    public List<DoctorDTO> searchDoctorsByName(String name) {
        return doctorRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public DoctorDTO getDoctorWithSchedules(Long doctorId) {
        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        return doctor.map(this::convertToDto).orElse(null);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(Long id, Doctor doctorDetails) {
        return doctorRepository.findById(id).map(doctor -> {
            doctor.setName(doctorDetails.getName());
            doctor.setSpecialization(doctorDetails.getSpecialization());
            doctor.setContactInfo(doctorDetails.getContactInfo());
            doctor.setExperience(doctorDetails.getExperience());
            doctor.setLanguages(doctorDetails.getLanguages());
            doctor.setRating(doctorDetails.getRating());
            return doctorRepository.save(doctor);
        }).orElse(null);
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    private DoctorDTO convertToDto(Doctor doctor) {
        DoctorDTO dto = new DoctorDTO();
        dto.setId(doctor.getId());
        dto.setName(doctor.getName());
        dto.setSpecialization(doctor.getSpecialization());
        dto.setContactInfo(doctor.getContactInfo());
        dto.setExperience(doctor.getExperience());
        dto.setLanguages(doctor.getLanguages());
        dto.setRating(doctor.getRating());

        List<DoctorScheduleDTO> scheduleDTOS = doctor.getSchedules().stream().map(s -> {
            DoctorScheduleDTO scheduleDTO = new DoctorScheduleDTO();
            scheduleDTO.setClinicName(s.getClinic().getName());
            scheduleDTO.setClinicAddress(s.getClinic().getAddress());
            scheduleDTO.setDayOfWeek(s.getDayOfWeek());
            scheduleDTO.setStartTime(s.getStartTime().toString());
            scheduleDTO.setEndTime(s.getEndTime().toString());
            scheduleDTO.setIsAvailable(s.isAvailable());
            return scheduleDTO;
        }).collect(Collectors.toList());

        dto.setSchedules(scheduleDTOS);
        return dto;
    }
}
