package com.pios.service;

import com.pios.persistence.model.Accommodation;
import com.pios.persistence.model.Order;
import com.pios.web.dto.AccommodationDTO;
import com.pios.web.dto.UserInfoDTO;

import java.util.List;

/**
 * Created by Matija on 3/8/2017.
 */
public interface AccommodationService {

    Accommodation addAccommodation(AccommodationDTO accommodationDTO, String username);
    Accommodation getAccommodation(int accommodationId);
    List<Accommodation> fetchAllAccommodations();
    List<Accommodation> fetchUserAccommodation(String username);
    void setAccommodationOrder(Order order);
    Order getOrderById(Integer orderId);
    void saveOrderandUpdateUserInfo(Order order,UserInfoDTO userInfo);
}
