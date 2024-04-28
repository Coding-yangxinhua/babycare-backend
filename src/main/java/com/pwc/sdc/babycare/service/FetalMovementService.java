package com.pwc.sdc.babycare.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pwc.sdc.babycare.domain.FetalMovement;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pwc.sdc.babycare.domain.vo.FetalMovementVo;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* @author Xinhua X Yang
* @description 针对表【BC_FETAL_MOVEMENT(Fetal Movement表)】的数据库操作Service
* @createDate 2024-04-03 10:38:02
*/
public interface FetalMovementService extends IService<FetalMovement> {

    List<FetalMovementVo> search(Date startDate, Date endDate);

}
