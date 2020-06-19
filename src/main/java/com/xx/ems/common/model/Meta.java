package com.xx.ems.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Meta implements Serializable {
    private String msg;

    private Integer status;


}
