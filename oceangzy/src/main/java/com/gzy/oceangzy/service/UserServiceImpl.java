package com.gzy.oceangzy.service;

import com.gzy.oceangzy.entity.User;
import com.gzy.oceangzy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public User getUserByPhone(String phone) {
        return userRepository.findUserByPhoneNumber(phone);
    }

    @Transactional
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }


}
