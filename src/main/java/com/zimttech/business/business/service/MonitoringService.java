package com.zimttech.business.business.service;

import com.zimttech.business.business.enums.BloodPressureEnum;

public interface MonitoringService {
    BloodPressureEnum checkBloodPressure(int systolic, int diastolic);
    void checkBMI(double height, double weight);
}
