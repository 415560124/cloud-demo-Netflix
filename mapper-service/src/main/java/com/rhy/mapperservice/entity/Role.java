package com.rhy.mapperservice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author Herion Lemon
 * @since 2021-02-05
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@TableName("role")
public class Role implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 编号
     */
    @TableId(value = "rol_id", type = IdType.AUTO)
    private Integer rolId;

    /**
     * 角色名
     */
    @TableField("rol_name")
    private String rolName;

    /**
     * 角色备注
     */
    @TableField("rol_note")
    private String rolNote;

    /**
     * 关联角色菜单集
     */
    @TableField(exist = false)
    private List<RoleMenu> roleMenus;
}
