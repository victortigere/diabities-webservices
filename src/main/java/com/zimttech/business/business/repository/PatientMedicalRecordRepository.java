package com.zimttech.business.business.repository;

import com.zimttech.business.business.model.Patient;
import com.zimttech.business.business.model.PatientMedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientMedicalRecordRepository extends JpaRepository<PatientMedicalRecord, Long> {
    Optional<PatientMedicalRecord> getPatientMedicalRecordByPatient(Patient patient);
}
