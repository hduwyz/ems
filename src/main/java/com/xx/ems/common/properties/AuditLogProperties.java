package com.xx.ems.common.properties;

import lombok.Getter;
import lombok.Setter;

/**
 * 审计日志配置
 */
@Setter
@Getter
public class AuditLogProperties {
    /**
     * 是否开启审计日志
     */
    private Boolean enabled = false;
    /**
     * 日志记录类型(logger/redis/db/es)
     */
    private String logType;
}
