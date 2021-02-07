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
 * 用户表
 * </p>
 *
 * @author Herion Lemon
 * @since 2021-02-05
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 编号
     */
    @TableId(value = "use_id", type = IdType.AUTO)
    private Integer useId;

    /**
     * 用户名
     */
    @TableField("use_name")
    private String useName;

    /**
     * 密码
     */
    @TableField("use_pwd")
    private String usePwd;

    /**
     * 备注
     */
    @TableField("use_note")
    private String useNote;
    /**
     * 用户角色关联集
     */
    @TableField(exist = false)
    private List<UserRole> userRoles;
}
