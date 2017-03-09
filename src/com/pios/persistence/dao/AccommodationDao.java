package com.pios.persistence.dao;

import com.pios.persistence.model.Accommodation;
import com.pios.persistence.model.Image;
import com.pios.web.dto.AccommodationDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Matija on 3/8/2017.
 */
public interface AccommodationDao {

    Accommodation addAccommodation(AccommodationDTO accommodationDTO);
    List<Accommodation> getAllAccommodations();
    Image addImage(Image image);
}
