package com.zimttech.business.business.service.impl;

import com.zimttech.business.business.payload.AlertPayload;
import com.zimttech.business.business.service.AlertsService;
import org.springframework.stereotype.Service;

@Service
public class AlertsServiceImpl implements AlertsService {
    @Override
    public void sendAlert(AlertPayload alertPayload) {
        System.out.println(alertPayload.getMessage());
    }
}
