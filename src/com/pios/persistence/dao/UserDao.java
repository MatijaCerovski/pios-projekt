package com.pios.persistence.dao;

/**
 * Created by Matija on 3/2/2017.
 */

import com.pios.persistence.model.User;
import com.pios.web.dto.UserInfoDTO;
import com.pios.web.dto.UserRegistrationDTO;

import java.util.List;


public interface UserDao {

    User findByUserName(String username);

    User findByEmail(String email);

    User registerNewUserAccount(UserRegistrationDTO userDTO);

    List<User> getAllUsers();

    void updateUserInfo(UserInfoDTO userInfo);
}