package com.zimttech.business.business.controller;

import com.zimttech.business.business.payload.BaseResult;
import com.zimttech.business.business.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patients/reports")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ReportsController {
    private final ReportService reportService;

    @GetMapping("/all")
    public ResponseEntity<BaseResult> getPatients(){
        return reportService.getReports();
    }
}
