package com.zimttech.business.business.payload;

import lombok.Data;

@Data
public class PatientRecordRequest {
    private Long patient;
    public int systolic;
    public int diastolic;
    private double weight;
    private double height;
    private double sugarLevel;

    public PatientRecordRequest(Long patient, int systolic,int diastolic, double weight, double height, double sugarLevel) {
        this.patient = patient;
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.weight = weight;
        this.height = height;
        this.sugarLevel = sugarLevel;
    }
}
