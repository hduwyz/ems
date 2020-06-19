package com.xx.ems.controller;


import com.xx.ems.common.model.Result;
import com.xx.ems.mapper.entity.Department;
import com.xx.ems.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author wangyz
 * @since 2020-06-18
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    @PostMapping("/saveOrUpdate")
    public Result<Long> saveOrUpdateUser(@RequestBody Department department){
        Boolean result = departmentService.saveOrUpdate(department);
        if (!result){
            return Result.failed("操作失败！");
        }
        return Result.success(department.getId(), "操作成功");
    }

    @PostMapping("/del")
    public Result<Boolean> del(@RequestBody Long departmentId){
        Boolean result = departmentService.removeById(departmentId);
        if (!result){
            return Result.failed("操作失败！");
        }
        return Result.success(result, "操作成功");
    }

    @PostMapping("/query")
    public Result<List<Department>> select(){
        List<Department> result = departmentService.list();
        return Result.success(result, "操作成功");
    }
}

