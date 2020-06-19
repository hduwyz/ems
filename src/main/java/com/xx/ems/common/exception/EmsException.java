package com.xx.ems.common.exception;

public class EmsException extends RuntimeException{

    /**
     * 
     */
    private static final long serialVersionUID = -8716100844379461082L;
    //自定义异常码
    private Integer code;


    public Integer getCode() {
        return code;
    }


    public void setCode(Integer code) {
        this.code = code;
    }


    public EmsException(String message, Integer code) {
        // 父类的构造函数；调用底层的Throwable的构造函数，将参数message赋值到detailMessage (Throwable的属性)
        super(message);
        //赋值code码
        this.code = code;
    }

    public EmsException(String message) {
        // 父类的构造函数；调用底层的Throwable的构造函数，将参数message赋值到detailMessage (Throwable的属性)
        super(message);
    }
}
