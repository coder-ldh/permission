package com.ldh.permission.core.controller;

import com.ldh.permission.core.annotation.Permission;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: ldh
 * @Date: 2018/12/15 18:26
 */
@RequestMapping(value = "/user")
@RestController
public class UserController {


    @Permission(value = "user:list")
    @GetMapping
    public List<String> userList(){
        String[] arrays = {"list","add","del","update"};
        List<String> strings = Arrays.asList(arrays);
        return strings;
    }

    @Permission(value = "user:add")
    @PostMapping
    public List<String> add(){
        String[] arrays = {"list","add","del","update"};
        List<String> strings = Arrays.asList(arrays);
        return strings;
    }
}
