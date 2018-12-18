package com.ldh.permission.core.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ldh.permission.core.model.Admin;
import com.ldh.permission.core.model.AdminResource;
import com.ldh.permission.core.model.po.LoginPO;
import com.ldh.permission.core.model.vo.ResultVO;
import com.ldh.permission.core.service.AdminResourceService;
import com.ldh.permission.core.service.AdminService;
import com.ldh.permission.core.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ldh
 * @Date: 2018/12/18 15:00
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    public static final String ADMIN_PERMISSION_LIST_ID = "ADMIN_PERMISSION_LIST_ID_";

    @Autowired
    RedisService redisService;
    @Autowired
    AdminResourceService adminResourceService;
    @Autowired
    AdminService adminService;

    @PostMapping(value = "/login")
    public ResultVO login(@RequestBody LoginPO loginPO){
        String name = loginPO.getName();
        String password = loginPO.getPassword();
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password)){
            return ResultVO.fail("参数有误");
        }
        EntityWrapper<Admin> wrapper = new EntityWrapper<>();
        wrapper.eq("user_name", name);
        Admin admin = adminService.selectOne(wrapper);
        if (admin == null){
            return ResultVO.fail("用户不存在");
        }
        Long adminId = admin.getAdminId();
        /*将权限加入到缓存*/
        permissionPutToCache(adminId);
        return ResultVO.success(admin);
    }

    /**
     * 将权限放到缓存里
     */
    void permissionPutToCache(Long adminId){
        EntityWrapper<AdminResource> wrapper = new EntityWrapper<>();
        wrapper.eq("admin_id",adminId);
        List<AdminResource> adminResources = adminResourceService.selectList(wrapper);
        List<String> permissionList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(adminResources)){
            adminResources.stream().forEach(e->{
                String permission = e.getPermission();
                if (!StringUtils.isEmpty(permission)){
                    permissionList.add(permission);
                }
            });
        }
        if (!CollectionUtils.isEmpty(permissionList)){
            redisService.set(ADMIN_PERMISSION_LIST_ID + adminId , JSONObject.toJSONString(permissionList));
        }
    }
}
