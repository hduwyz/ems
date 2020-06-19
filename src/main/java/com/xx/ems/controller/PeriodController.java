package com.xx.ems.controller;


import com.xx.ems.common.model.Result;
import com.xx.ems.common.model.request.PeriodRequest;
import com.xx.ems.mapper.entity.Period;
import com.xx.ems.service.IPeriodService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 * 期次表 前端控制器
 * </p>
 *
 * @author wangyz
 * @since 2020-06-18
 */
@Controller
@RequestMapping("/period")
public class PeriodController {

    @Autowired
    private IPeriodService periodService;

    @PostMapping("/saveOrUpdate")
    public Result<Long> saveOrUpdatePeriod(@RequestBody PeriodRequest periodRequest){
        Period period = new Period();
        BeanUtils.copyProperties(periodRequest, period);
        Boolean result = periodService.saveOrUpdate(period);
        if (!result){
            return Result.failed("操作失败！");
        }
        return Result.success(period.getId(), "操作成功");
    }


    @PostMapping("/query")
    public Result<List<Period>> query(){
        List<Period> result = periodService.list();
        return Result.success(result, "操作成功");
    }

    @PostMapping("/del")
    public Result<Boolean> delPeriod(Long periodId){
        Boolean result = periodService.removeById(periodId);
        return Result.success(result, "操作成功");
    }

}

