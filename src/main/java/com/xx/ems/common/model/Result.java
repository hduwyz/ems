package com.xx.ems.common.model;

import com.xx.ems.common.constant.ResultCode;
import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private T data;

    private Meta meta;

    public Result(T data, Meta meta){
        this.data = data;
        this.meta = meta;
    }

    public static <T> Result<T> success(){
        return new Result<>(null, new Meta(null, 200));
    }

    public static <T> Result<T> success(String msg){
        return new Result<>(null, new Meta(msg, 200));
    }

    public static <T> Result<T> success(T data, String msg){
        return new Result<>(data, new Meta(msg, 200));
    }

    public static <T> Result<T> failed(){
        return new Result<>(null, new Meta(null, 500));
    }

    public static <T> Result<T> failed(String msg){
        return new Result<>(null, new Meta(msg, 500));
    }

    public static <T> Result<T> failed(Integer code, String msg){
        return new Result<>(null, new Meta(msg, code));
    }

    public static <T> Result<T> failed(ResultCode resultCode){
        return new Result<>(null, new Meta(resultCode.getDesc(), resultCode.getCode()));
    }
}
