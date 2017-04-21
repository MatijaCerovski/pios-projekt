package com.pios.web.controller;

import com.pios.persistence.model.Order;
import com.pios.persistence.model.User;
import com.pios.service.AccommodationService;
import com.pios.service.IUserService;
import com.pios.web.dto.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/details/{accommodationId}/")
public class Rent{

    @Autowired
    @Qualifier("userService")
    IUserService userService;

    @Autowired
    @Qualifier("accommodationService")
    AccommodationService accommodationService;


    @GetMapping("/rent/{orderId}")
    @PreAuthorize("hasAnyRole('ROLE_USER' , 'ROLE_ADMIN')")
    public String openRent(@PathVariable Integer orderId, Model model, Principal principal){

        User user = userService.getUserByUsername(principal.getName());

        UserInfoDTO userInfoDTO = new UserInfoDTO();

        userInfoDTO = convertUserToUserDTO(user, userInfoDTO);

        Order order = accommodationService.getOrderById(orderId);

        model.addAttribute("userInfo", userInfoDTO);
        model.addAttribute("orderID", orderId);
        model.addAttribute("order", order);

        return "rent";
    }

    @PostMapping("/rent/confirm")
    @PreAuthorize("hasAnyRole('ROLE_USER' , 'ROLE_ADMIN')")
    public ModelAndView rentAccommodation(@ModelAttribute("userInfo") @Valid UserInfoDTO userInfo, BindingResult result,
                                          WebRequest request, Errors errors, Principal principal) {

        Integer orderId = Integer.parseInt(request.getParameter("orderId"));

        Order order = accommodationService.getOrderById(orderId);
        order.setUsername(principal.getName());
        order.setReserved(true);

        if (result.hasErrors()) {
            //vrati ga na stranicu i reci da nekaj nevalja
            for (Object object : result.getAllErrors()) {
                if(object instanceof FieldError) {
                    FieldError fieldError = (FieldError) object;

                    System.out.println(fieldError.getCode());
                }

                if(object instanceof ObjectError) {
                    ObjectError objectError = (ObjectError) object;

                    System.out.println(objectError.getCode());
                }
            }
            return new ModelAndView("redirect:/error");
        } else {
            accommodationService.saveOrderandUpdateUserInfo(order, userInfo);
            //spremi narudbu, podatke korisnika
            return new ModelAndView("redirect:/profile");
        }

    }


    private UserInfoDTO convertUserToUserDTO(User user, UserInfoDTO userInfoDTO) {

        if(user.getUserInfo().getName() != null){
            userInfoDTO.setName(user.getUserInfo().getName());
        }
        if(user.getUserInfo().getSurname() != null){
            userInfoDTO.setSurname(user.getUserInfo().getSurname());
        }
        if(user.getUserInfo().getBirthDate() != null){
            userInfoDTO.setBirthDate(user.getUserInfo().getBirthDate());
        }
        if(user.getUserInfo().getCityTown() != null){
            userInfoDTO.setCityTown(user.getUserInfo().getCityTown());
        }
        if(user.getUserInfo().getPostalCode() != null){
            userInfoDTO.setPostalCode(user.getUserInfo().getPostalCode());
        }
        if(user.getUserInfo().getStreetName() != null){
            userInfoDTO.setStreetName(user.getUserInfo().getStreetName());
        }
        if(user.getUserInfo().getStreetNumber() != null){
            userInfoDTO.setStreetNumber(user.getUserInfo().getStreetNumber());
        }
        if(user.getUserInfo().getPhone() != null){
            userInfoDTO.setPhone(user.getUserInfo().getPhone());
        }
        if(user.getUserInfo().getCellPhone() != null){
            userInfoDTO.setCellPhone(user.getUserInfo().getCellPhone());
        }

        userInfoDTO.setUserInfoId(user.getUserInfo().getUserInfoId());
        userInfoDTO.setUsername(user.getUsername());

        return userInfoDTO;
    }

}
