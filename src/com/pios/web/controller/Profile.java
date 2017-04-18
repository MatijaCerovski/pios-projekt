package com.pios.web.controller;

import com.pios.service.AccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * Created by Matija on 17.4.2017..
 */
@Controller
@RequestMapping("/profile")
public class Profile {

    @Autowired
    @Qualifier("accommodationService")
    AccommodationService accommodationService;

    @GetMapping()
    @PreAuthorize("hasAnyRole('ROLE_USER' , 'ROLE_ADMIN')")
    public String openProfile(Model model, Principal principal){

        model.addAttribute("accommodations",accommodationService.fetchUserAccommodation(principal.getName()));

        return "profile";
    }
}
