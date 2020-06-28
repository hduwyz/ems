package com.xx.ems.mapper.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author wangyz
 * @since 2020-06-18
 */
@Data
public class Permission implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 父id
     */
    private Long pid;

    /**
     * 权限等级 0-一级 1-二级 2-三级
     */
    private Integer level;

    private String apiService;

    private String apiAction;

    private String apiPath;

    @Override
    public String toString() {
        return "Permission{" +
        "id=" + id +
        ", name=" + name +
        ", pid=" + pid +
        ", level=" + level +
        "}";
    }
}
