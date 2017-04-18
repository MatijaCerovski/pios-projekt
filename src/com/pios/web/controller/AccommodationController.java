package com.pios.web.controller;

import com.pios.persistence.model.Accommodation;
import com.pios.service.AccommodationService;
import com.pios.web.dto.AccommodationDTO;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;

/**
 * Created by Matija on 18.4.2017..
 */
@Controller
@RequestMapping("/add/accommodation")
public class AccommodationController{

    @Autowired
    @Qualifier("accommodationService")
    AccommodationService accommodationService;


    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN' , 'ROLE_USER')")
    public String addAccommodation(Model model){

        AccommodationDTO accommodationDTO = new AccommodationDTO();
        model.addAttribute("accommodation", accommodationDTO);

        return "addAccommodation";
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN' , 'ROLE_USER')")
    public ModelAndView addAccommodation(@ModelAttribute("accommodation") @Valid AccommodationDTO accommodationDTO, BindingResult result,
                                         WebRequest request, Errors errors, Principal principal) {

        for(MultipartFile tmp : accommodationDTO.getImages()){
            if(!tmp.getContentType().equals("image/jpeg")){
                //nije dobra extenzija baci error neki
                return new ModelAndView("redirect:/wrongFileExtension");
            }
        }

        Accommodation accommodation = accommodationService.addAccommodation(accommodationDTO, principal.getName());


        if (result.hasErrors()) {
            return new ModelAndView("/add/accommodation", "accommodation", accommodationDTO);
        } else {
            return new ModelAndView("redirect:/");
            // return "redirect:/login";
        }
    }
}
