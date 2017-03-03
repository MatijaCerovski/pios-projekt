package com.pios.persistence.dao;

import com.pios.persistence.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matija on 3/2/2017.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public User findByUserName(String username) {

        List<User> users = new ArrayList<User>();

        users = sessionFactory.getCurrentSession().createQuery("from User where username=?").setParameter(0, username)
                .list();

        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }

    }

    @SuppressWarnings("unchecked")
    public User findByEmail(String email) {

        List<User> users = new ArrayList<User>();

        users = sessionFactory.getCurrentSession().createQuery("from User where email=?").setParameter(0, email).list();

        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
    }
}
