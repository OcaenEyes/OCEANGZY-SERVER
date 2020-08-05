package com.gzy.oceangzy.repository;


import com.gzy.oceangzy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT user FROM User user WHERE user.phoneNumber=?1")
    User findUserByPhoneNumber(String phone);

    @Modifying
    @Query("UPDATE User user SET user.friends=?2 WHERE user.phoneNumber=?1 ")
    void saveFriend(String phone, List<User> friends);

}
