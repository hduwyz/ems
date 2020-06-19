package com.xx.ems.controller;


import com.xx.ems.common.model.Result;
import com.xx.ems.common.model.request.RoleRequest;
import com.xx.ems.mapper.entity.Role;
import com.xx.ems.service.IRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangyz
 * @since 2020-06-18
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @PostMapping("/saveOrUpdate")
    public Result<Long> saveOrUpdateRole(@RequestBody RoleRequest roleRequest){
        Role role = new Role();
        BeanUtils.copyProperties(roleRequest, role);
        Boolean result = roleService.saveOrUpdate(role);
        if (!result){
            return Result.failed("操作失败！");
        }
        return Result.success(role.getId(), "操作成功");
    }


    @PostMapping("/query")
    public Result<List<Role>> queryList(){
        List<Role> result = roleService.list();
        return Result.success(result, "操作成功");
    }

    @PostMapping("/del")
    public Result<Boolean> delRole(Long roleId){
        Boolean result = roleService.removeById(roleId);
        return Result.success(result, "操作成功");
    }
}

