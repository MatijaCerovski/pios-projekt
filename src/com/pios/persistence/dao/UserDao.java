package com.pios.persistence.dao;

/**
 * Created by Matija on 3/2/2017.
 */

import com.pios.persistence.model.User;


public interface UserDao {

    User findByUserName(String username);

    User findByEmail(String email);

}