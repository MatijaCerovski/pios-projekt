package com.pios.service;

import com.pios.persistence.model.User;
import com.pios.web.dto.UserRegistrationDTO;

import java.util.List;

/**
 * Created by Matija on 3/4/2017.
 */
public interface IUserService {

    User saveUser(UserRegistrationDTO userDTO);

    List<User> getAllUsers();


}