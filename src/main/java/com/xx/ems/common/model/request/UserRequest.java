package com.xx.ems.common.model.request;

import lombok.Data;

@Data
public class UserRequest {

    private Long id;

    private String username;

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

    /**
     * 1：表示启用 0:表示禁用,
     */
    private Boolean status;
}
