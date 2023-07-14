package com.zimttech.business.business.model;

import com.zimttech.business.business.enums.BloodPressureEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientMedicalRecord extends BaseEntity{
    @OneToOne
    private Patient patient;
    public int systolic;
    public int diastolic;
    private double weight;
    private double height;
    private double sugarLevel;
    private BloodPressureEnum level;
}
