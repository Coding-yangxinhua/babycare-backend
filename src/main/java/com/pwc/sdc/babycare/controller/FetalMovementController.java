package com.pwc.sdc.babycare.controller;

import cn.hutool.core.date.DateUtil;
import com.pwc.sdc.babycare.common.bean.ResponseEntity;
import com.pwc.sdc.babycare.domain.FetalMovement;
import com.pwc.sdc.babycare.domain.dto.FetalMovementDto;
import com.pwc.sdc.babycare.service.FetalMovementCountService;
import com.pwc.sdc.babycare.service.FetalMovementService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Xinhua X Yang
 */
@RestController
@RequestMapping("/fetalMovement")
public class FetalMovementController {

    @Autowired
    private FetalMovementService fetalMovementService;

    @Autowired
    private FetalMovementCountService fetalMovementCountService;
    @PostMapping("/record")
    public ResponseEntity<String> record(@RequestBody FetalMovementDto fetalMovementDto) {
        fetalMovementService.save(fetalMovementDto);
        Long id = fetalMovementDto.getId();
        fetalMovementDto.getClickRecords().forEach(count -> {
            count.setFmId(id);
        });
        fetalMovementCountService.saveBatch(fetalMovementDto.getClickRecords());
        return ResponseEntity.ok();
    }

    @PostMapping("/record")
    public ResponseEntity<Map<String, List<FetalMovement>>> list() {
        List<FetalMovement> fetalList = fetalMovementService.list();
        Map<String, List<FetalMovement>> groupedFetal = fetalList.stream().collect(Collectors.groupingBy(fetal -> {
            return DateUtil.format(fetal.getStartTime(), "yyyy-MM-dd");
        }));
        return ResponseEntity.ok(groupedFetal);
    }
}
