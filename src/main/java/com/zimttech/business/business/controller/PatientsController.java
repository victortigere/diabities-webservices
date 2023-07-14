package com.zimttech.business.business.controller;

import com.zimttech.business.business.payload.PatientRecordRequest;
import com.zimttech.business.business.service.PatientService;
import com.zimttech.business.business.payload.BaseResult;
import com.zimttech.business.business.payload.PatientRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients/")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class PatientsController {
    private final PatientService patientService;

    @PostMapping("/add")
    public ResponseEntity<BaseResult> addPatient(@RequestBody PatientRequest request){
        return patientService.addPatient(request);
    }

    @PostMapping("/add/medical/record")
    public ResponseEntity<BaseResult> addPatientRecord(@RequestBody PatientRecordRequest request){
        return patientService.addPatientMedicalRecord(request);
    }

    @GetMapping("/all")
    public ResponseEntity<BaseResult> getPatients(){
        return patientService.getPatients();
    }

    @GetMapping("records/all")
    public ResponseEntity<BaseResult> getPatientsRecords(){
        return patientService.getMedicalRecords();
    }

    @GetMapping("patient/{id}")
    public ResponseEntity<BaseResult> getPatient(@PathVariable Long id){
        return patientService.getPatient(id);
    }

    @GetMapping("record/{id}")
    public ResponseEntity<BaseResult> getPatientsRecords(@PathVariable Long id){
        return patientService.getMedicalRecord(id);
    }

    @PutMapping("record/edit")
    public ResponseEntity<BaseResult> editPatientsRecord(@RequestBody PatientRecordRequest request){
        return patientService.editPatientMedicalRecord(request);
    }

}
