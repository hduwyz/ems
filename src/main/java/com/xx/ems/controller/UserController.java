package com.xx.ems.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xx.ems.common.exception.EmsException;
import com.xx.ems.common.model.Result;
import com.xx.ems.common.model.request.UserRequest;
import com.xx.ems.common.model.vo.PageResult;
import com.xx.ems.common.model.vo.UserVO;
import com.xx.ems.mapper.entity.Role;
import com.xx.ems.mapper.entity.User;
import com.xx.ems.service.IRoleService;
import com.xx.ems.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangyz
 * @since 2020-06-18
 */

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/saveOrUpdate")
    public Result<Long> saveOrUpdateUser(@RequestBody UserRequest userRequest){
        if (userRequest.getId() == null){
            User existUser = userService.getUserInfoByUsername(userRequest.getUsername());
            if (existUser != null){
                log.info("用户名username:{}已经存在", userRequest.getUsername());
                throw new EmsException("该用户名已经存在");
            }
        }
        User user = new User();
        BeanUtils.copyProperties(userRequest, user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Boolean result = userService.saveOrUpdate(user);
        if (!result){
            return Result.failed("操作失败！");
        }
        return Result.success(user.getId(), "操作成功");
    }

    @GetMapping("/query")
    public Result<PageResult> queryList(UserRequest queryInfo){
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper();
        wrapper.select(User::getId, User::getUsername, User::getEmail, User::getPhone,
                User::getCreateTime, User::getDepartId);
        Page result = userService.page(queryInfo);
        PageResult pageResult = new PageResult();
        pageResult.setTotal(result.getTotal());
        if (CollectionUtils.isEmpty(result.getRecords())){
            return Result.success(pageResult, "操作成功");
        }
        List<UserVO> list = new ArrayList<>();
        List<User> records = result.getRecords();
        Set<Long> roleIdList = records.stream().map(User::getRoleId).collect(Collectors.toSet());
        List<Role> roleList = roleService.listByIds(roleIdList);
        if (CollectionUtils.isEmpty(roleList)){
            throw new EmsException("没有该用户角色，用户角色id: " + JSONObject.toJSONString(roleIdList));
        }
        Map<Long, List<Role>> roleMap = roleList.stream().collect(Collectors.groupingBy(Role::getId));
        records.stream().forEach(v -> {
            UserVO userVO = new UserVO();
            userVO.setId(v.getId());
            userVO.setEmail(v.getEmail());
            userVO.setUsername(v.getUsername());
            userVO.setMg_state(v.getStatus());
            userVO.setMobile(v.getPhone());
            if (!CollectionUtils.isEmpty(roleMap.get(v.getRoleId()))){
                userVO.setRole_name(roleMap.get(v.getRoleId()).get(0).getRoleName());
            }
            list.add(userVO);
        });
        pageResult.setResult(list);
        return Result.success(pageResult, "操作成功");
    }

    @PostMapping("/del")
    public Result<Boolean> delUser(Long userId){
        Boolean result = userService.removeById(userId);
        return Result.success(result, "操作成功");
    }

    @PutMapping("/{id}/state/{state}")
    public Result<Boolean> changeStatus(@PathVariable("id") Long userId, @PathVariable("state") Boolean state){
        User user = new User();
        user.setId(userId);
        user.setStatus(state);
        Boolean result = userService.updateById(user);
        return Result.success(result, "操作成功");
    }
}

