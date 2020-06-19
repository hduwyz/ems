package com.xx.ems.common.model.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserVO implements Serializable {
    private Long id;

    /**
     * 员工名称
     */
    private String name;

    private String password;

    /**
     * 部门id
     */
    private Long departId;

    private Long roleId;

    /**
     * 手机号
     */
    private Integer phone;

    /**
     * 邮箱地址
     */
    private String email;
}
