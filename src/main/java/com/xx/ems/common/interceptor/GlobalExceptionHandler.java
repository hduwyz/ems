package com.xx.ems.common.interceptor;

import com.xx.ems.common.exception.EmsException;
import com.xx.ems.common.model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public Result<String> exceptionHandler(HttpServletRequest request, Exception e){
        //绑定异常是需要明确提示给用户的
        if (e instanceof MethodArgumentNotValidException) {
            logger.info("传入参数校验失败："+e.getMessage(), e);
            MethodArgumentNotValidException exception=(MethodArgumentNotValidException) e;
            //获取自错误信息
            StringBuilder msg = new StringBuilder();
            for(ObjectError error : exception.getBindingResult().getAllErrors()) {
                msg.append(error.getDefaultMessage()).append(";\n");
            }
            //将具体错误信息设置到CodeMsg中返回
            return Result.failed(msg.toString());
        } else if(e instanceof EmsException){
            logger.info("业务数据异常："+ e.getMessage(),e);
            EmsException exception=(EmsException) e;
            //获取自错误信息
            String msg= exception.getMessage();
            //将具体错误信息设置到CodeMsg中返回
            return Result.failed(msg);
        }else if (e instanceof SQLException){
            logger.info("操作数据库异常："+ e.getMessage(),e);
            return Result.failed("该数据有关联数据，操作失败!");
        } else if (e != null) {
            logger.info("其他异常：" + e.getMessage(), e);
            return Result.failed("服务器异常，请联系管理员！！！");
        }
        // 其余异常简单返回为服务器异常
        logger.info("其他异常：null");
        return Result.failed("服务器异常，请联系管理员！！！");
    }
}
