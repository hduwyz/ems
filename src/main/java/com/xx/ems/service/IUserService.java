package com.xx.ems.service;

import com.xx.ems.mapper.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangyz
 * @since 2020-06-18
 */
public interface IUserService extends IService<User> {

    User getUserInfoByUsername(String username);
}
