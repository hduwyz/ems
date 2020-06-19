package com.xx.ems.controller;


import com.xx.ems.common.model.Result;
import com.xx.ems.common.model.request.WorkContentRequest;
import com.xx.ems.mapper.entity.WorkContent;
import com.xx.ems.service.IWorkContentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 * 上周工作总结及本周工作计划 前端控制器
 * </p>
 *
 * @author wangyz
 * @since 2020-06-18
 */
@Controller
@RequestMapping("/workContent")
public class WorkContentController {

    @Autowired
    private IWorkContentService workContentService;

    @PostMapping("/saveOrUpdate")
    public Result<Long> saveOrUpdate(@RequestBody WorkContentRequest workContentRequest){
        WorkContent workContent = new WorkContent();
        BeanUtils.copyProperties(workContentRequest, workContent);
        Boolean result = workContentService.saveOrUpdate(workContent);
        if (!result){
            return Result.failed("操作失败！");
        }
        return Result.success(workContent.getId(), "操作成功");
    }


    @PostMapping("/query")
    public Result<List<WorkContent>> queryList(){
        List<WorkContent> result = workContentService.list();
        return Result.success(result, "操作成功");
    }

    @PostMapping("/del")
    public Result<Boolean> del(Long workContentId){
        Boolean result = workContentService.removeById(workContentId);
        return Result.success(result, "操作成功");
    }
}

