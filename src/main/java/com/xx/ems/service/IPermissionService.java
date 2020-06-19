package com.xx.ems.service;

import com.xx.ems.common.model.vo.MenuVO;
import com.xx.ems.mapper.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author wangyz
 * @since 2020-06-18
 */
public interface IPermissionService extends IService<Permission> {

    List<MenuVO> getMenuList(Long userId);
}
