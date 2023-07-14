package com.zimttech.business.business.service.impl;

import com.zimttech.business.business.enums.BloodPressureEnum;
import com.zimttech.business.business.model.PatientMedicalRecord;
import com.zimttech.business.business.payload.BPPayload;
import com.zimttech.business.business.payload.BaseResult;
import com.zimttech.business.business.repository.PatientMedicalRecordRepository;
import com.zimttech.business.business.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportsServiceImpl implements ReportService {

    private final PatientMedicalRecordRepository patientMedicalRecordRepository;

    @Override
    public ResponseEntity<BaseResult> getReports() {
        List<PatientMedicalRecord> recordList = patientMedicalRecordRepository.findAll();

        Long low = recordList.stream().filter(record -> record.getLevel() == BloodPressureEnum.LOW).count();
        Long normal = recordList.stream().filter(record -> record.getLevel() == BloodPressureEnum.NORMAL).count();
        Long elevated = recordList.stream().filter(record -> record.getLevel() == BloodPressureEnum.ELEVATED).count();
        Long hypertension_1 = recordList.stream().filter(record -> record.getLevel() == BloodPressureEnum.HYPERTENSION_1).count();
        Long hypertension_2 = recordList.stream().filter(record -> record.getLevel() == BloodPressureEnum.HYPERTENSION_2).count();
        Long hypertension_crisis = recordList.stream().filter(record -> record.getLevel() == BloodPressureEnum.HYPERTENSIVE_CRISIS).count();

        BPPayload lowBp = BPPayload.builder()
                .level(BloodPressureEnum.LOW)
                .patients(low.intValue())
                .build();
        BPPayload normalBP = BPPayload.builder()
                .level(BloodPressureEnum.NORMAL)
                .patients(normal.intValue())
                .build();
        BPPayload elevatedBP = BPPayload.builder()
                .level(BloodPressureEnum.ELEVATED)
                .patients(elevated.intValue())
                .build();
        BPPayload hypertension_1BP = BPPayload.builder()
                .level(BloodPressureEnum.HYPERTENSION_1)
                .patients(hypertension_1.intValue())
                .build();
        BPPayload hypertension_2BP = BPPayload.builder()
                .level(BloodPressureEnum.HYPERTENSION_2)
                .patients(hypertension_2.intValue())
                .build();
        BPPayload hypertension_crisisBP = BPPayload.builder()
                .level(BloodPressureEnum.HYPERTENSIVE_CRISIS)
                .patients(hypertension_crisis.intValue())
                .build();

        List<BPPayload> bpPayloads = new ArrayList<>();
        bpPayloads.add(lowBp);
        bpPayloads.add(normalBP);
        bpPayloads.add(elevatedBP);
        bpPayloads.add(hypertension_1BP);
        bpPayloads.add(hypertension_2BP);
        bpPayloads.add(hypertension_crisisBP);

        return ResponseEntity.ok(new BaseResult(bpPayloads,
                "Reports fetched successfully",
                "00",
                400 ));
    }
}
