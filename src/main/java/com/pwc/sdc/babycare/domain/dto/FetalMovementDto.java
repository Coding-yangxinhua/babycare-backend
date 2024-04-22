package com.pwc.sdc.babycare.domain.dto;

import com.pwc.sdc.babycare.domain.FetalMovement;
import com.pwc.sdc.babycare.domain.FetalMovementCount;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class FetalMovementDto extends FetalMovement{
    private List<FetalMovementCount> clickRecords;
}
