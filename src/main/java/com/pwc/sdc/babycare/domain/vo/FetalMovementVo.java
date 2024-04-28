package com.pwc.sdc.babycare.domain.vo;

import com.pwc.sdc.babycare.domain.FetalMovement;
import lombok.Data;

import java.util.List;

@Data
public class FetalMovementVo {
    String  date;

    List<FetalMovement> dataList;
}
