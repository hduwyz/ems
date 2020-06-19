package com.xx.ems.service;


import com.xx.ems.common.model.Audit;

/**
 * 审计日志接口
 */
public interface IAuditService {
    void save(Audit audit);
}
