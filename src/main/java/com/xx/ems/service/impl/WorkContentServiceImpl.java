package com.xx.ems.service.impl;

import com.xx.ems.mapper.entity.WorkContent;
import com.xx.ems.mapper.WorkContentMapper;
import com.xx.ems.service.IWorkContentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 上周工作总结及本周工作计划 服务实现类
 * </p>
 *
 * @author wangyz
 * @since 2020-06-18
 */
@Service
public class WorkContentServiceImpl extends ServiceImpl<WorkContentMapper, WorkContent> implements IWorkContentService {

}
