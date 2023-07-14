package com.zimttech.business.business.service;

import com.zimttech.business.business.payload.AlertPayload;

public interface AlertsService {
    void sendAlert(AlertPayload alertPayload);
}
