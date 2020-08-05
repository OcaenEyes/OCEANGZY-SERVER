package com.gzy.oceangzy.controller;


import com.gzy.oceangzy.entity.User;
import com.gzy.oceangzy.service.UserService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@Api
public class UserController {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public Object login(@RequestParam String phone, @RequestParam String password) {
        Map map = new HashMap<>();
        Map _map = new HashMap();
        User user = userService.getUserByPhone(phone);
        if (user != null && !user.equals("")) {
            if (user.getPassWord().equals(password)) {
                map.put("code", "200");
                map.put("message", "登录成功");
                _map.put("id", user.getId());
                _map.put("userId", user.getUserId());
                _map.put("phoneNumber", user.getPhoneNumber());
                _map.put("avatarUrl", user.getAvatarUrl());
                _map.put("nickName", user.getNickName());
                _map.put("signWord", user.getSignWord());
                _map.put("createTime", user.getCreateTime());
                _map.put("updateTime", user.getUpdateTime());
                map.put("userInfo", _map);
                logger.info(String.valueOf(map));
                return map;
            } else {
                map.put("code", "102");
                map.put("message", "账号密码错误");
                return map;
            }
        } else {
            map.put("code", "101");
            map.put("message", "账号不存在");
            return map;

        }
    }

    @PostMapping("/register")
    @ResponseBody
    public Object register(@RequestParam String phone, @RequestParam String password) {
        Map map = new HashMap<>();
        Map _map = new HashMap();
        User user = userService.getUserByPhone(phone);
        if (user == null || user.equals("")) {
            User user1 = new User();
            user1.setPhoneNumber(phone);
            user1.setPassWord(password);
            user1.setUserId(UUID.randomUUID().toString());
            user1.setAvatarUrl("assets/images/3.jpg");
            user1.setSignWord("这个人很懒，木有签名");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = simpleDateFormat.format(new Date());
            user1.setCreateTime(date);
            user1.setNickName(phone);
            User user2 = userService.saveUser(user1);
            map.put("code", "200");
            map.put("message", "注册成功");
            _map.put("id", user2.getId());
            _map.put("userId", user2.getUserId());
            _map.put("phoneNumber", user2.getPhoneNumber());
            _map.put("avatarUrl", user2.getAvatarUrl());
            _map.put("nickName", user2.getNickName());
            _map.put("signWord", user2.getSignWord());
            _map.put("createTime", user2.getCreateTime());
            _map.put("updateTime", user2.getUpdateTime());
            map.put("userInfo", _map);
            return map;

        } else {
            map.put("code", "103");
            map.put("message", "账号已存在");
            return map;
        }
    }


}
