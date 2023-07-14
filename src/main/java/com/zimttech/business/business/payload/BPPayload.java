package com.zimttech.business.business.payload;

import com.zimttech.business.business.enums.BloodPressureEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BPPayload {
    private BloodPressureEnum level;
    private int patients;
}
