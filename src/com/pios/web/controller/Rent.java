package com.pios.web.controller;

import com.pios.persistence.model.User;
import com.pios.service.IUserService;
import com.pios.web.dto.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import java.security.Principal;

@Controller
@RequestMapping("/details/{accommodationId}/")
public class Rent{

    @Autowired
    @Qualifier("userService")
    IUserService userService;


    @GetMapping("/rent/{orderId}")
    @PreAuthorize("hasAnyRole('ROLE_USER' , 'ROLE_ADMIN')")
    public String openRent(@PathVariable int orderId, Model model, Principal principal){

        User user = userService.getUserByUsername(principal.getName());

        UserInfoDTO userInfoDTO = new UserInfoDTO();

        convertUserToUserDTO(user, userInfoDTO);

        model.addAttribute("userInfo", userInfoDTO);

        return "rent";
    }

    private void convertUserToUserDTO(User user, UserInfoDTO userInfoDTO) {
        userInfoDTO.setName(user.getUserInfo().getName());
        userInfoDTO.setSurname(user.getUserInfo().getSurname());
        userInfoDTO.setBirthDate(user.getUserInfo().getBirthDate());
        userInfoDTO.setCityTown(user.getUserInfo().getCityTown());
        userInfoDTO.setPostalCode(user.getUserInfo().getPostalCode());
        userInfoDTO.setStreetName(user.getUserInfo().getStreetName());
        userInfoDTO.setStreetNumber(user.getUserInfo().getStreetNumber());
        userInfoDTO.setPhone(user.getUserInfo().getPhone());
        userInfoDTO.setCellPhone(user.getUserInfo().getCellPhone());
        userInfoDTO.setUserInfoId(user.getUserInfo().getUserInfoId());
        userInfoDTO.setUsername(user.getUsername());
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
