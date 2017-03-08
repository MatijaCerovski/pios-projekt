package com.pios.persistence.dao;

import com.pios.persistence.model.Accommodation;
import com.pios.web.dto.AccommodationDTO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
