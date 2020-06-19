package com.xx.ems.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xx.ems.common.exception.EmsException;
import com.xx.ems.common.model.Result;
import com.xx.ems.common.model.request.UserRequest;
import com.xx.ems.common.model.vo.UserVO;
import com.xx.ems.mapper.entity.User;
import com.xx.ems.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

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


    @PostMapping("/query")
    public Result<List<User>> queryList(){
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper();
        wrapper.select(User::getId, User::getUsername, User::getEmail, User::getPhone,
                User::getCreateTime, User::getDepartId);
        List<User> result = userService.list(wrapper);
        return Result.success(result, "操作成功");
    }

    @PostMapping("/del")
    public Result<Boolean> delUser(Long userId){
        Boolean result = userService.removeById(userId);
        return Result.success(result, "操作成功");
    }

}

