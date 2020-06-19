package com.xx.ems.service.impl;

import com.xx.ems.mapper.entity.Department;
import com.xx.ems.mapper.DepartmentMapper;
import com.xx.ems.service.IDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author wangyz
 * @since 2020-06-18
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

}
