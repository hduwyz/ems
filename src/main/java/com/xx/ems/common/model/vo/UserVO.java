package com.xx.ems.common.model.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserVO implements Serializable {
    private Long id;

    /**
     * 员工名称
     */
    private String username;

//    private String password;

    private String role_name;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱地址
     */
    private String email;

    private Boolean mg_state;
}
