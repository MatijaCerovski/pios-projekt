package com.pios.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Matija on 3/5/2017.
 */
@Controller
public class AccessDenied {


    @GetMapping("/403")
    public String openError(Model model){

        return "403";

    }
}
