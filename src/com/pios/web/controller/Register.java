package com.pios.web.controller;

import com.pios.persistence.model.User;
import com.pios.service.IUserService;
import com.pios.web.dto.UserRegistrationDTO;
import com.pios.web.error.UserAlreadyExistException;
import com.pios.web.error.UsernameAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
 * Created by Matija on 3/4/2017.
 */
@Controller
@RequestMapping("/register")
public class Register {


    @Autowired
    @Qualifier("userService")
    IUserService userService;

    @GetMapping
    public String openRegister(Model model){

        UserRegistrationDTO user = new UserRegistrationDTO();
        model.addAttribute("user", user);

        return "register";
    }



    @PostMapping
    public ModelAndView registerUser(@ModelAttribute("user") @Valid UserRegistrationDTO user, BindingResult result,
                                     WebRequest request, Errors errors) {
        // Check if user exist
        // Check if email exist
        // Check if password match
        // If not create user and redirect to login
        // Else redirect to register with error msg
/*
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(user.getUsername());
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		System.out.println(user.getMatchingPassword());
		System.out.println("-----------------------------------------------------------------------------------");
*/
        User registered = new User();
        if (!result.hasErrors()) {
            try {
                registered = createUserAccount(user, result);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                // e.printStackTrace();
                if (e instanceof UserAlreadyExistException) {
                    result.rejectValue("email", "", e.getMessage());
                }
                if (e instanceof UsernameAlreadyExistException) {
                    result.rejectValue("username", "", e.getMessage());
                }
            }
        }

        if (result.hasErrors()) {
            return new ModelAndView("register", "user", user);
        } else {
            return new ModelAndView("redirect:/login");
            // return "redirect:/login";
        }

    }

    private User createUserAccount(UserRegistrationDTO userRegistrationDTO, BindingResult result) throws Exception {

        User registered = null;

        try {
            registered = userService.saveUser(userRegistrationDTO);
        } catch (UserAlreadyExistException | UsernameAlreadyExistException e) {
            // posali exception dalje
            throw e;
        }

        return registered;
    }


}
