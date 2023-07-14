package com.zimttech.business.business.service;

import com.zimttech.business.business.payload.BaseResult;
import org.springframework.http.ResponseEntity;

public interface ReportService {
    ResponseEntity<BaseResult> getReports();
}
