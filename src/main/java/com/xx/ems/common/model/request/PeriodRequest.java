package com.xx.ems.common.model.request;

import lombok.Data;

@Data
public class PeriodRequest {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 周报期次
     */
    private String period;
}
