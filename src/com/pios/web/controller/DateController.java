package com.pios.web.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * Created by Matija on 18.4.2017..
 */
@Controller
@RequestMapping("/add/accommodation/date")
public class DateController {

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_USER' , 'ROLE_ADMIN')")
    public String dodajDatumSmjestaja(@RequestParam("from") Date from, @RequestParam("to") Date to){

        System.out.println(from.toString()+"----"+to.toString());


        return "redirect:/profile";
    }
}
