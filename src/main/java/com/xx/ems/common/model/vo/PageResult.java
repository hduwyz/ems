package com.xx.ems.common.model.vo;

import lombok.Data;

@Data
public class PageResult<T> {

    private Long total;

    private T result;
}
