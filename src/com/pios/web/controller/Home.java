package com.pios.web.controller;

import com.pios.service.AccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {

    @Autowired
    AccommodationService accommodationService;

    @GetMapping("/")
    public String openHome(Model model) {
        model.addAttribute("accommodations", accommodationService.fetchAllAccommodations());
        
        return "index";
    }
	
}
