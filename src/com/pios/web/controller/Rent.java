package com.pios.web.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("/details/{accommodationId}/")
public class Rent{


    @GetMapping("/rent/{orderId}")
    public String openRent(@PathVariable int orderId){

        return "rent";
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_USER' , 'ROLE_ADMIN')")
    public void rentAccommodation(BindingResult result,
                                  WebRequest request, Errors errors) {

        if (result.hasErrors()) {
//
        } else {
//
            // return "redirect:/login";
        }

    }

}
