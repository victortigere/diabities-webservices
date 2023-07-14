package com.zimttech.business.business.service;

import com.zimttech.business.business.payload.PatientRecordRequest;
import com.zimttech.business.business.payload.BaseResult;
import com.zimttech.business.business.payload.PatientRequest;
import org.springframework.http.ResponseEntity;

public interface PatientService {
    ResponseEntity<BaseResult> addPatient(PatientRequest request);
    ResponseEntity<BaseResult> addPatientMedicalRecord(PatientRecordRequest request);
    ResponseEntity<BaseResult> getPatients();
    ResponseEntity<BaseResult> getMedicalRecords();
    ResponseEntity<BaseResult> editPatientMedicalRecord(PatientRecordRequest request);
    ResponseEntity<BaseResult> getPatient(Long id);
    ResponseEntity<BaseResult> getMedicalRecord(Long id);
}
