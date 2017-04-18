package com.pios.web.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Matija on 18.4.2017..
 */
@Controller
@RequestMapping("/add/date")
public class DateController {

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_USER' , 'ROLE_ADMIN')")
    public String dodajDatumSmjestaja(Model model){


        return "redirect:/profile";
    }
}
