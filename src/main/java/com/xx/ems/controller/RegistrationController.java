package com.xx.ems.controller;


import com.xx.ems.common.model.Result;
import com.xx.ems.common.model.request.RegistrationRequest;
import com.xx.ems.common.model.request.WorkContentRequest;
import com.xx.ems.mapper.entity.Registration;
import com.xx.ems.mapper.entity.WorkContent;
import com.xx.ems.service.IRegistrationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 * 加减分登记表 前端控制器
 * </p>
 *
 * @author wangyz
 * @since 2020-06-18
 */
@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private IRegistrationService registrationService;

    @PostMapping("/saveOrUpdate")
    public Result<Long> saveOrUpdate(@RequestBody RegistrationRequest registrationRequest){
        Registration registration = new Registration();
        BeanUtils.copyProperties(registrationRequest, registration);
        Boolean result = registrationService.saveOrUpdate(registration);
        if (!result){
            return Result.failed("操作失败！");
        }
        return Result.success(registration.getId(), "操作成功");
    }


    @PostMapping("/query")
    public Result<List<Registration>> queryList(){
        List<Registration> result = registrationService.list();
        return Result.success(result, "操作成功");
    }

    @PostMapping("/del")
    public Result<Boolean> del(Long registrationId){
        Boolean result = registrationService.removeById(registrationId);
        return Result.success(result, "操作成功");
    }
}

