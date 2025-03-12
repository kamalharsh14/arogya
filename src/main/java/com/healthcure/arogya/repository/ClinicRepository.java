package com.healthcure.arogya.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
import com.healthcure.arogya.model.Clinic;

public interface ClinicRepository extends JpaRepository<Clinic, Long> {
    List<Clinic> findByNameContainingIgnoreCase(String name);
}
