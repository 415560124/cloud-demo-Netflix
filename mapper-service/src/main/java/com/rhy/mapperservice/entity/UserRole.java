package com.rhy.mapperservice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户角色关联表
 * </p>
 *
 * @author Herion Lemon
 * @since 2021-02-05
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@TableName("user_role")
public class UserRole implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 角色编号
     */
    @TableId("rol_id")
    private Integer rolId;

    /**
     * 用户编号
     */
    @TableField("use_id")
    private Integer useId;
    /**
     * 角色对象
     */
    @TableField(exist = false)
    private Role role;
}
