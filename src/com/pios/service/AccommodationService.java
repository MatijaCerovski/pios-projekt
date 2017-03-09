package com.pios.service;

import com.pios.persistence.model.Accommodation;
import com.pios.web.dto.AccommodationDTO;

import java.util.List;

/**
 * Created by Matija on 3/8/2017.
 */
public interface AccommodationService {

    Accommodation addAccommodation(AccommodationDTO accommodationDTO);
    List<Accommodation> fetchAllAccommodations();
}
