package com.pios.web.controller;

import com.pios.persistence.model.Accommodation;
import com.pios.persistence.model.Order;
import com.pios.service.AccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Date;


/**
 * Created by Matija on 18.4.2017..
 */
@Controller
@RequestMapping("/add/accommodation/date")
public class DateController {

    @Autowired
    @Qualifier("accommodationService")
    AccommodationService accommodationService;

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_USER' , 'ROLE_ADMIN')")
    public String dodajDatumSmjestaja(@RequestParam("from") Date from, @RequestParam("to") Date to,
                                      @RequestParam("accommodationId") int accommodationId,
                                      @RequestParam("price") int price){


        Accommodation accommodation = new Accommodation();
        accommodation.setAccommodationId(accommodationId);

        Order order = new Order();
        order.setStartDate(from);
        order.setEndDate(to);
        order.setPrice(price);
        order.setReserved(false);
        order.setAccommodation(accommodation);

        accommodationService.setAccommodationOrder(order);

        return "redirect:/profile";
    }
}
