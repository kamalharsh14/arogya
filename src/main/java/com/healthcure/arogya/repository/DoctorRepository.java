package com.healthcure.arogya.repository;

import com.healthcure.arogya.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findByNameContainingIgnoreCase(String name);
    List<Doctor> findBySpecialization(String specialization);
}
