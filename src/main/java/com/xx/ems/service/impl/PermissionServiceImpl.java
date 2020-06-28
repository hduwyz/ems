package com.xx.ems.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xx.ems.common.model.vo.MenuVO;
import com.xx.ems.mapper.entity.Permission;
import com.xx.ems.mapper.PermissionMapper;
import com.xx.ems.mapper.entity.Role;
import com.xx.ems.mapper.entity.User;
import com.xx.ems.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xx.ems.service.IRoleService;
import com.xx.ems.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author wangyz
 * @since 2020-06-18
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private PermissionMapper permissionMapper;

    /**
     * 1、获取所有菜单项
     * 2、组装菜单的树状结构
     * @param userId
     * @return
     */
    @Override
    public List<MenuVO> getMenuList(Long userId) {
        User user = userService.getById(userId);
        Long roleId = user.getRoleId();
        Role role = roleService.getById(roleId);
        String psIds = role.getPsIds();
        List<String> psIdList = Arrays.asList(psIds.split(","));

        List<MenuVO> menuList = new ArrayList<>();
        LambdaQueryWrapper<Permission> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.in(Permission::getLevel, 0, 1);
        queryWrapper.in(Permission::getId, psIdList);
        List<Permission> permissionList = permissionMapper.selectList(queryWrapper);
        if (CollectionUtils.isEmpty(permissionList)){
            return menuList;
        }
        Map<Integer, List<Permission>> groupByLevelMap = permissionList.stream().collect(Collectors.groupingBy(Permission::getLevel));
        List<Permission> levelZeroList = groupByLevelMap.get(0);
        levelZeroList.stream().forEach(v -> {
            MenuVO menuVO = new MenuVO();
            convert(menuVO, v);
            menuList.add(menuVO);
        });
        List<Permission> levelOneList = groupByLevelMap.get(1);
        if (!CollectionUtils.isEmpty(levelOneList)){
            Map<Long, List<Permission>> groupByLevelOneMap = levelOneList.stream().collect(Collectors.groupingBy(Permission::getPid));
            menuList.stream().forEach(v -> {
                List<MenuVO> temp = new ArrayList<>();
                List<Permission> list = groupByLevelOneMap.get(v.getId());
                if (CollectionUtils.isEmpty(list)){
                    return;
                }
                convert(temp, list);
                v.setChildren(temp);
            });
        }
        return menuList;
    }

    private void convert(List<MenuVO> menuVOList, List<Permission> permissionList){
        MenuVO menuVO = null;
        for (Permission permission: permissionList){
            menuVO = new MenuVO();
            convert(menuVO, permission);
            menuVOList.add(menuVO);
        }
    }
    private void convert(MenuVO menuVO, Permission permission){
        menuVO.setAuthName(permission.getName());
        menuVO.setId(permission.getId());
        menuVO.setOrder(permission.getLevel());
        menuVO.setPath(permission.getApiPath());
    }
}
