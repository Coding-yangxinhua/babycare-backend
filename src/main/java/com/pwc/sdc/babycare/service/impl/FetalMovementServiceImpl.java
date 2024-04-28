package com.pwc.sdc.babycare.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pwc.sdc.babycare.domain.FetalMovement;
import com.pwc.sdc.babycare.domain.vo.FetalMovementVo;
import com.pwc.sdc.babycare.service.FetalMovementService;
import com.pwc.sdc.babycare.mapper.FetalMovementMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
* @author Xinhua X Yang
* @description 针对表【BC_FETAL_MOVEMENT(Fetal Movement表)】的数据库操作Service实现
* @createDate 2024-04-03 10:38:02
*/
@Service
public class FetalMovementServiceImpl extends ServiceImpl<FetalMovementMapper, FetalMovement>
    implements FetalMovementService{

    @Override
    public List<FetalMovementVo> search(Date startDate, Date endDate) {
        DateTime startTime = null, endTime = null;
        if (startDate != null) {
            startTime = DateUtil.beginOfDay(startDate);
        }
        if (endDate != null) {
            endTime = DateUtil.beginOfDay(endDate);
        }
        // 根据日期倒叙排
        LambdaQueryWrapper<FetalMovement> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.ge(startTime != null, FetalMovement::getGmtCreate, startTime)
                .le(endTime != null, FetalMovement::getGmtCreate, endTime)
                .orderByDesc(FetalMovement::getStartTime);
        List<FetalMovement> records = this.list(queryWrapper);
        // 根据yyyy-MM-dd分组
        LinkedHashMap<String, List<FetalMovement>> map = records.stream().collect(Collectors.groupingBy(fetal -> DateUtil.format(fetal.getStartTime(), "yyyy-MM-dd"), LinkedHashMap::new,
                Collectors.toList()));
        List<FetalMovementVo> fetalMovementVos = new ArrayList<>(map.size());
        FetalMovementVo fetalMovementVo;
        for (Map.Entry<String, List<FetalMovement>> entry : map.entrySet()) {
            fetalMovementVo = new FetalMovementVo();
            fetalMovementVo.setDate(entry.getKey());
            fetalMovementVo.setDataList(entry.getValue());
            fetalMovementVos.add(fetalMovementVo);
        }
        return fetalMovementVos;
    }
}




