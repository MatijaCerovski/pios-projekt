package com.pios.service;

import com.pios.persistence.dao.AccommodationDao;
import com.pios.persistence.model.Accommodation;
import com.pios.web.dto.AccommodationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Matija on 3/8/2017.
 */
@Service("accommodationService")
public class AccommodationServiceImpl implements AccommodationService {

    @Autowired
    AccommodationDao accommodationDao;

    @Transactional
    @Override
    public Accommodation addAccommodation(AccommodationDTO accommodationDTO) {
        return accommodationDao.addAccommodation(accommodationDTO);
    }
}
