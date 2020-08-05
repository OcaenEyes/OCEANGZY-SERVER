package com.gzy.oceangzy.service;

import com.gzy.oceangzy.entity.User;

public interface UserService {

    User getUserByPhone(String phone);

    User saveUser(User user);
}
