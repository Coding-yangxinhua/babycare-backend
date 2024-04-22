package com.pwc.sdc.babycare.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Fetal Movement Count表
 * @TableName BC_FETAL_MOVEMENT_COUNT
 */
@TableName(value ="BC_FETAL_MOVEMENT_COUNT")
@Data
public class FetalMovementCount implements Serializable {
    /**
     * 主键ID
     */
    @TableId
    private Long id;

    /**
     * FM ID
     */
    private Long fmId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 点击时间
     */
    private Date clickTime;

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