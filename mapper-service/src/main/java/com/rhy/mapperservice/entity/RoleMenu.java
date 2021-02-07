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
 * 角色菜单关联表
 * </p>
 *
 * @author Herion Lemon
 * @since 2021-02-05
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@TableName("role_menu")
public class RoleMenu implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 角色编号
     */
    @TableId("rol_id")
    private Integer rolId;

    /**
     * 菜单编号
     */
    @TableField("men_id")
    private Integer menId;
    /**
     * 菜单对象
     */
    @TableField(exist = false)
    private Menu menu;


}
