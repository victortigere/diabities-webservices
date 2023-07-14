package com.zimttech.business.business.service.impl;

import com.zimttech.business.business.enums.BMIEnum;
import com.zimttech.business.business.enums.BloodPressureEnum;
import com.zimttech.business.business.service.AlertsService;
import com.zimttech.business.business.service.MonitoringService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MonitoringServiceImpl implements MonitoringService {
    private final AlertsService alertsService;

    @Override
    public BloodPressureEnum checkBloodPressure(int systolic, int diastolic ) {
        if (systolic < 90 || diastolic < 60) {
            return BloodPressureEnum.LOW;
        } else if (systolic >= 90 && systolic <= 119 && diastolic >= 60 && diastolic <= 79) {
            return BloodPressureEnum.NORMAL;
        } else if ((systolic >= 120 && systolic <= 129) && diastolic < 80) {
            return BloodPressureEnum.ELEVATED;
        } else if ((systolic >= 130 && systolic <= 139) || (diastolic >= 80 && diastolic <= 89)) {
            return BloodPressureEnum.HYPERTENSION_1;
        } else if (systolic >= 140 || diastolic >= 90) {
            return BloodPressureEnum.HYPERTENSION_2;
        }  else if (systolic > 180 || diastolic >= 120) {
            return BloodPressureEnum.HYPERTENSION_2;
        }
        return null;
    }

    @Override
    public void checkBMI(double height, double weight) {
        double bmi = weight / (height * height);
        if (bmi < 18.5) {
            System.out.println(BMIEnum.UNDERWEIGHT);
        } else if (bmi >= 18.5 && bmi < 25) {
            System.out.println(BMIEnum.NORMAL);
        } else if (bmi >= 25 && bmi < 30) {
            System.out.println(BMIEnum.OVERWEIGHT);
        } else if (bmi >= 30) {
            System.out.println(BMIEnum.OBESE);
        }
    }
}
