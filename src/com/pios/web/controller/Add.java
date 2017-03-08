package com.pios.web.controller;

import com.pios.persistence.model.Accommodation;
import com.pios.service.AccommodationService;
import com.pios.web.dto.AccommodationDTO;
import com.pios.web.dto.UserRegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by Matija on 3/7/2017.
 */
@Controller
@RequestMapping("/add")
public class Add {

    @Autowired
    @Qualifier("accommodationService")
    AccommodationService accommodationService;


    @GetMapping("/accommodation")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addAccommodation(Model model){

        AccommodationDTO accommodationDTO = new AccommodationDTO();
        model.addAttribute("accommodation", accommodationDTO);

        return "addAccommodation";
    }

    @PostMapping("/accommodation")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView addAccommodation(@ModelAttribute("accommodation") @Valid AccommodationDTO accommodationDTO, BindingResult result,
                                     WebRequest request, Errors errors) {

        Accommodation accommodation = accommodationService.addAccommodation(accommodationDTO);


        if (result.hasErrors()) {
            return new ModelAndView("/add/accommodation", "accommodation", accommodationDTO);
        } else {
            return new ModelAndView("redirect:/");
            // return "redirect:/login";
        }
    }


}
