package com.healthcure.arogya.repository;

import com.healthcure.arogya.model.DoctorClinicSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface DoctorClinicScheduleRepository extends JpaRepository<DoctorClinicSchedule, Long> {
    List<DoctorClinicSchedule> findByDoctorId(Long doctorId);
}
