package com.pwc.sdc.babycare.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pwc.sdc.babycare.common.bean.ResponseEntity;
import com.pwc.sdc.babycare.domain.FetalMovement;
import com.pwc.sdc.babycare.domain.dto.FetalMovementDto;
import com.pwc.sdc.babycare.service.FetalMovementCountService;
import com.pwc.sdc.babycare.service.FetalMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


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

    @GetMapping("/search")
    public ResponseEntity<Page<FetalMovement>> search(Date startDate, Date endDate, Integer pageNo, Integer size) {
        Page<FetalMovement> page = new Page<>(pageNo, size);
        DateTime startTime = DateUtil.beginOfDay(startDate);
        DateTime endTime = DateUtil.endOfDay(endDate);
        // 根据日期倒叙排
        LambdaQueryWrapper<FetalMovement> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.ge(FetalMovement::getGmtCreate, startTime)
                .le(FetalMovement::getGmtCreate, endTime)
                .orderByDesc(FetalMovement::getGmtCreate);
        return ResponseEntity.ok(fetalMovementService.page(page, queryWrapper));
    }

    @GetMapping("/today")
    public ResponseEntity<List<FetalMovement>> today() {
        Date today = new Date();
        DateTime startTime = DateUtil.beginOfDay(today);
        DateTime endTime = DateUtil.endOfDay(today);
        // 根据日期倒叙排
        LambdaQueryWrapper<FetalMovement> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.ge(FetalMovement::getGmtCreate, startTime)
                .le(FetalMovement::getGmtCreate, endTime)
                .orderByDesc(FetalMovement::getGmtCreate);
        return ResponseEntity.ok(fetalMovementService.getBaseMapper().selectList(queryWrapper));
    }
}
