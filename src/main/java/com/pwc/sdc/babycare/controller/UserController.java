package com.pwc.sdc.babycare.controller;

import cn.hutool.core.date.DateUtil;
import com.pwc.sdc.babycare.common.bean.ResponseEntity;
import com.pwc.sdc.babycare.domain.FetalMovement;
import com.pwc.sdc.babycare.domain.dto.FetalMovementDto;
import com.pwc.sdc.babycare.service.FetalMovementCountService;
import com.pwc.sdc.babycare.service.FetalMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Xinhua X Yang
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private FetalMovementService fetalMovementService;

    @Autowired
    private FetalMovementCountService fetalMovementCountService;

}
