package com.pwc.sdc.babycare.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Fetal Movement表
 * @TableName BC_FETAL_MOVEMENT
 */
@TableName(value ="BC_FETAL_MOVEMENT")
@Data
public class FetalMovement implements Serializable {
    /**
     * 主键ID
     */
    @TableId
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    private Date startTime;

    private Date endTime;

    private Integer validCount;

    private Integer totalCount;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

    /**
     * 逻辑删除
     */
    @TableField(fill = FieldFill.INSERT)

    private Integer deleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}