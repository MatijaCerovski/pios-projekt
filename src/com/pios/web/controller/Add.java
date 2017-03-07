package com.pios.web.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Matija on 3/7/2017.
 */
@Controller
@RequestMapping("/add")
public class Add {


    @GetMapping("/accommodation")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addAccommodation(Model model){

        return "addAccommodation";
    }
}
