package com.xx.ems.service.impl;

import com.xx.ems.mapper.entity.Registration;
import com.xx.ems.mapper.RegistrationMapper;
import com.xx.ems.service.IRegistrationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 加减分登记表 服务实现类
 * </p>
 *
 * @author wangyz
 * @since 2020-06-18
 */
@Service
public class RegistrationServiceImpl extends ServiceImpl<RegistrationMapper, Registration> implements IRegistrationService {

}
