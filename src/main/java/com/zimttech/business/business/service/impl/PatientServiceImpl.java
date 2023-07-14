package com.zimttech.business.business.service.impl;

import com.zimttech.business.business.enums.BloodPressureEnum;
import com.zimttech.business.business.model.Patient;
import com.zimttech.business.business.model.PatientMedicalRecord;
import com.zimttech.business.business.payload.BaseResult;
import com.zimttech.business.business.payload.PatientRecordRequest;
import com.zimttech.business.business.payload.PatientRequest;
import com.zimttech.business.business.repository.PatientMedicalRecordRepository;
import com.zimttech.business.business.repository.PatientRepository;
import com.zimttech.business.business.service.MonitoringService;
import com.zimttech.business.business.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientMedicalRecordRepository patientMedicalRecordRepository;
    private final MonitoringService monitoringService;

    @Override
    public ResponseEntity<BaseResult> addPatient(PatientRequest request) {
        Optional<Patient> patientToCheck = patientRepository.getPatientByNationalID(request.getNationalID());

        if(patientToCheck.isPresent()){
            return ResponseEntity.ok(new BaseResult("01", "Patient already registered", 01 ));
        }

        Patient patient = Patient.builder()
                .firstName(request.getFirstName())
                .lastName(request.getFirstName())
                .age(request.getAge())
                .address(request.getAddress())
                .nationalID(request.getNationalID())
                .build();
        patientRepository.save(patient);
        return ResponseEntity.ok(new BaseResult("01", "Patient registered successfully", 00 ));
    }

    @Override
    public ResponseEntity<BaseResult> addPatientMedicalRecord(PatientRecordRequest request) {
        Optional<Patient> patient = patientRepository.findById(request.getPatient());

        // check patient availability
        if(!patient.isPresent()){
            return ResponseEntity.ok(new BaseResult("01", "Patient not registered", 400 ));
        }

        Optional<PatientMedicalRecord> medicalRecord = patientMedicalRecordRepository
               .getPatientMedicalRecordByPatient(patient.get());

        //check if patient already has a medical record added
        if(medicalRecord.isPresent()){
            return ResponseEntity.ok(new BaseResult("01", "Patient record already added", 400 ));
        }

        //get sugar level
        BloodPressureEnum bpLevel = monitoringService.checkBloodPressure(request.systolic, request.diastolic);

        PatientMedicalRecord patientMedicalRecord = PatientMedicalRecord.builder()
                .patient(patient.get())
                .diastolic(request.diastolic)
                .systolic(request.getSystolic())
                .height(request.getHeight())
                .sugarLevel(request.getSugarLevel())
                .weight(request.getWeight())
                .level(bpLevel)
                .build();
        patientMedicalRecordRepository.save(patientMedicalRecord);;
        return ResponseEntity.ok(new BaseResult("00", "Patient Record added successfully", 200 ));
    }

    @Override
    public ResponseEntity<BaseResult> getPatients() {
        return ResponseEntity.ok(new BaseResult(
                patientRepository.findAll(),
                "00",
                "Patients fetched successfully",
                200 ));
    }

    @Override
    public ResponseEntity<BaseResult> getMedicalRecords() {
        return ResponseEntity.ok(new BaseResult(
                patientMedicalRecordRepository.findAll(),
                "00",
                "Medical Records fetched successfully",
                200 ));
    }

    @Override
    public ResponseEntity<BaseResult> editPatientMedicalRecord(PatientRecordRequest request) {
        Optional<Patient> patient = patientRepository.findById(request.getPatient());

        // check patient availability
        if(!patient.isPresent()){
            return ResponseEntity.ok(new BaseResult("01", "Patient not found", 200 ));
        }

        Optional<PatientMedicalRecord> medicalRecord = patientMedicalRecordRepository
                .getPatientMedicalRecordByPatient(patient.get());

        //check if patient record exists
        if(!medicalRecord.isPresent()){
            return ResponseEntity.ok(new BaseResult("01", "Patient record not found", 200 ));
        }

        PatientMedicalRecord editedMedicalRecord = medicalRecord.get();
        editedMedicalRecord.setWeight(request.getWeight());
        editedMedicalRecord.setHeight(request.getHeight());
        editedMedicalRecord.setSystolic(request.getSystolic());
        editedMedicalRecord.setDiastolic(request.getDiastolic());
        editedMedicalRecord.setSugarLevel(request.getSugarLevel());
        patientMedicalRecordRepository.save(editedMedicalRecord);

        return ResponseEntity.ok(new BaseResult("00", "Patient Medical Record edited successfully", 200 ));
    }

    @Override
    public ResponseEntity<BaseResult> getPatient(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);

        // check patient availability
        if(!patient.isPresent()){
            return ResponseEntity.ok(new BaseResult("01", "Patient not found", 200 ));
        }

        return ResponseEntity.ok(new BaseResult(
                patient.get(),
                "01",
                "Patient fetched successfully",
                200 ));
    }

    @Override
    public ResponseEntity<BaseResult> getMedicalRecord(Long id) {
        Optional<Patient> toCheckPatient = patientRepository.findById(id);

        // check patient availability
        if(!toCheckPatient.isPresent()){
            return ResponseEntity.ok(new BaseResult("00", "Patient not found", 200 ));
        }

        Optional<PatientMedicalRecord> medicalRecord = patientMedicalRecordRepository
                .getPatientMedicalRecordByPatient(toCheckPatient.get());

        //check if patient record exists
        if(!medicalRecord.isPresent()){
            return ResponseEntity.ok(new BaseResult("01", "Patient record not found", 200 ));
        }

        return ResponseEntity.ok(new BaseResult(
                medicalRecord.get(),
                "Patient fetched successfully",
                "00",
                200 ));
    }
}
