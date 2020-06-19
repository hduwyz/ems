package com.xx.ems.common.constant;

import lombok.Getter;

@Getter
public enum ResultCode {

    USER_ACCOUNT_EXPIRED(1000001, "账号过期"),
    USER_CREDENTIALS_ERROR(1000002, "密码错误"),
    USER_CREDENTIALS_EXPIRED(1000003, "密码过期"),
    USER_ACCOUNT_DISABLE(1000004, "账号不可用"),
    USER_ACCOUNT_LOCKED(1000005, "账号锁定"),
    USER_ACCOUNT_NOT_EXIST(1000006, "用户不存在"),
    COMMON_FAIL(1000007, "其他错误"),
    ;
    private String desc;
    private Integer code;

    ResultCode(Integer code, String desc){
        this.code = code;
        this.desc = desc;
    }

}
