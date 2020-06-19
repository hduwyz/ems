package com.xx.ems.controller;


import com.xx.ems.common.annotation.CurrentUser;
import com.xx.ems.common.model.Result;
import com.xx.ems.common.model.vo.MenuVO;
import com.xx.ems.mapper.entity.User;
import com.xx.ems.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangyz
 * @since 2020-06-18
 */
@RestController
@RequestMapping("/menus")
public class MenuController {

    @Autowired
    private IPermissionService permissionService;

    @GetMapping("/list")
    public Result<List<MenuVO>> getMenus(@CurrentUser User user){
        List<MenuVO> result = permissionService.getMenuList(user.getId());
        return Result.success(result, "操作成功");
    }

}

