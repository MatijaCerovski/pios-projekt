package com.pios.persistence.dao;

import com.pios.persistence.model.Accommodation;
import com.pios.persistence.model.Image;
import com.pios.web.dto.AccommodationDTO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by Matija on 3/8/2017.
 */
@Repository
public class AccommodationDaoImpl implements AccommodationDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Accommodation addAccommodation(AccommodationDTO accommodationDTO) {
        Accommodation accommodation = new Accommodation();
        accommodation.setName(accommodationDTO.getName());

        sessionFactory.getCurrentSession().save(accommodation);



        return accommodation;

    }

    @Override
    public List<Accommodation> getAllAccommodations() {

        List<Accommodation> accommodations = sessionFactory.getCurrentSession().createCriteria(Accommodation.class).list();

        return accommodations;
    }

    @Override
    public Image addImage(Image image) {

        sessionFactory.getCurrentSession().save(image);


        return image;
    }


}
