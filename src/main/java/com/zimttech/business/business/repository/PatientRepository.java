package com.zimttech.business.business.repository;

import com.zimttech.business.business.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> getPatientByNationalID(String nationalId);

    @Query("" +
            "SELECT CASE WHEN COUNT(p) > 0 THEN " +
            "TRUE ELSE FALSE END " +
            "FROM Patient p " +
            "WHERE p.nationalID = ?1"
    )
    Boolean selectExistsNationalId(String email);
}
