package com.webusermanagement.controller;

import com.webusermanagement.entity.CrmUser;
import com.webusermanagement.entity.User;
import com.webusermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;



    @GetMapping( "/showCustomLoginPage")
    public String showCustomPage(Model model)
    {   model.addAttribute("flag",0);
        return "custom-login";
    }

    @GetMapping( "/denied")
    public String showCustomDeniedPage()
    {
        return "access-denied-page";
    }

    @GetMapping( "/showRegistrationForm")
    public String showRegistrationForm(Model model,@RequestParam(value = "flag") Integer flag)
    {
        model.addAttribute("crmUser",new CrmUser());
        if(flag==0)
        return "registration-form";
        else return "registration-form-admin";
    }

    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(
            @Valid @ModelAttribute("crmUser") CrmUser theCrmUser,BindingResult theBindingResult,
            Model theModel) {

        String userName = theCrmUser.getUserName();


        // form validation
        if (theBindingResult.hasErrors()){
            return "registration-form";
        }

        // check the database if user already exists
        User existing = userService.findByUserName(userName);
        if (existing != null){
            theModel.addAttribute("crmUser", new CrmUser());
            theModel.addAttribute("registrationError", "User name already exists.");


            return "registration-form";
        }

        // create user account
        userService.save(theCrmUser);

        return "redirect:/user";


    }

    @PostMapping("/processRegistrationFormAdmin")
    public String processRegistrationFormAdmin(
            @Valid @ModelAttribute("crmUser") CrmUser theCrmUser,BindingResult theBindingResult,
            Model theModel) {

        String userName = theCrmUser.getUserName();


        // form validation
        if (theBindingResult.hasErrors()){
            return "registration-form";
        }

        // check the database if user already exists
        User existing = userService.findByUserName(userName);
        if (existing != null){
            theModel.addAttribute("crmUser", new CrmUser());
            theModel.addAttribute("registrationError", "User name already exists.");


            return "registration-form";
        }

        // create user account
        userService.save(theCrmUser);

        return "redirect:/list";


    }


}
