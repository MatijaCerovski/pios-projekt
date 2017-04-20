package com.pios.persistence.dao;

import com.pios.persistence.model.User;
import com.pios.persistence.model.UserRole;
import com.pios.persistence.model.UsersInfo;
import com.pios.web.dto.UserInfoDTO;
import com.pios.web.dto.UserRegistrationDTO;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private PasswordEncoder passwordEncoder;

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


    @Override
    public User registerNewUserAccount(UserRegistrationDTO userDTO) {

        // Umetnuti usera u bazu
        // Kreiranje user varijable
        User user = new User(userDTO.getUsername(), passwordEncoder.encode(userDTO.getPassword()), userDTO.getEmail(),
                true);
        // dodavanje ROLA u user varijablu
        UserRole userRole = new UserRole(user, "ROLE_USER");
        user.addUserRole(userRole);
        //kreiranje userInfo koji se sprema u bazu
        UsersInfo usersInfo = new UsersInfo(user);

        sessionFactory.getCurrentSession().save(user);
        sessionFactory.getCurrentSession().save(userRole);
        sessionFactory.getCurrentSession().save(usersInfo);

        return user;

    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        users = sessionFactory.getCurrentSession().createCriteria(User.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        return users;
    }

    @Override
    public void updateUserInfo(UserInfoDTO userInfo) {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("update UsersInfo set name = :name, " +
                "surname = :surname, " +
                "birthDate = :birthDate, " +
                "cityTown = :cityTown, " +
                "postalCode = :postalCode, " +
                "streetName = :streetName, " +
                "streetNumber = :streetNumber, " +
                "phone = :phone, " +
                "cellPhone = :cellPhone" +
                " where userInfoId = :userInfoId");



        query.setParameter("name", userInfo.getName());
        query.setParameter("surname", userInfo.getSurname());
        query.setParameter("birthDate", userInfo.getBirthDate());
        query.setParameter("cityTown", userInfo.getCityTown());
        query.setParameter("postalCode", userInfo.getPostalCode());
        query.setParameter("streetName", userInfo.getStreetName());
        query.setParameter("streetNumber", userInfo.getStreetNumber());
        if(userInfo.getPhone() != null){
            query.setParameter("phone", userInfo.getPhone());
        }else{
            query.setParameter("phone", 0);
        }
        query.setParameter("cellPhone", userInfo.getCellPhone());


        query.setParameter("userInfoId", userInfo.getUserInfoId());
        int result = query.executeUpdate();
    }

}
