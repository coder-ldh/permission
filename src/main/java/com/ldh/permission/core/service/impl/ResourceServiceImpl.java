package com.ldh.permission.core.service.impl;

import com.ldh.permission.core.model.Resource;
import com.ldh.permission.core.mapper.ResourceMapper;
import com.ldh.permission.core.service.ResourceService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 资源表 服务实现类
 * </p>
 *
 * @author ldh
 * @since 2018-12-17
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements ResourceService {
	
}
