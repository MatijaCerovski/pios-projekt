package com.pios.web.controller;

import com.pios.persistence.model.Accommodation;
import com.pios.persistence.model.Order;
import com.pios.service.AccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Matija on 14.4.2017..
 */
@Controller
@RequestMapping("/details")
public class Details {

    @Autowired
    @Qualifier("accommodationService")
    AccommodationService accommodationService;


    @GetMapping("/{accommodationId}")
    public String openDetails(Model model, @PathVariable int accommodationId){
        Accommodation accommodation = accommodationService.getAccommodation(accommodationId);
        Set<Order> orders = accommodation.getOrders().stream().filter(p -> !p.getReserved()).collect(Collectors.toSet());
        accommodation.setOrders(orders);

        model.addAttribute("accommodation", accommodation);
        return "details";
    }

}
