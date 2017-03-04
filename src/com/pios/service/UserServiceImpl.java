package com.pios.service;

import com.pios.persistence.dao.UserDao;
import com.pios.persistence.model.User;
import com.pios.web.dto.UserRegistrationDTO;
import com.pios.web.error.UserAlreadyExistException;
import com.pios.web.error.UsernameAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Matija on 3/4/2017.
 */

@Service("userService")
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserDao userDao;


    @Transactional
    @Override
    public User saveUser(UserRegistrationDTO userDTO) {
        // Provjeriti da li postoji user s tim emailom
        if (userDao.findByEmail(userDTO.getEmail()) != null) {
            throw new UserAlreadyExistException("There is an account with that email adress: " + userDTO.getEmail());
        }
        // Provjeriti da li je username slobodan
        if (userDao.findByUserName(userDTO.getUsername()) != null) {
            throw new UsernameAlreadyExistException("There is an account with that username: " + userDTO.getUsername());
        }

        // ako ne postoji takav korisnik dodati ga u bazu

        return userDao.registerNewUserAccount(userDTO);

    }


}
