package com.xx.ems.common.model.vo;

import lombok.Data;

import java.util.List;

@Data
public class MenuVO {
    private Long id;

    private String authName;

    private String path;

    private List<MenuVO> children;

    private Integer order;

}
