package com.pios.web.controller;

import com.pios.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Matija on 3/2/2017.
 */
@Controller
public class Admin {

    @Autowired
    IUserService iUserService;

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String openAdmin(Model model){

        model.addAttribute("users", iUserService.getAllUsers());

        return "admin";

    }
}
