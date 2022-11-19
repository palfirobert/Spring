package com.webusermanagement.controller;

import com.webusermanagement.entity.*;
import com.webusermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home()
    {

        return ("home-page");
    }

    @GetMapping("/user")
    public String user(Model model)
    {Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user=userService.findByUserName(auth.getName());
        model.addAttribute("user",user);
        return ("user-page");
    }

    @GetMapping("/admin")
    public String admin()
    {
        return ("redirect:/list");
    }

    @GetMapping("/owner")
    public String owner()
    {
        return ("owner-page");
    }

    @GetMapping("/list")
    private String listEmployees(Model model){
        List<User> users=userService.findAll();
        model.addAttribute("users",users);
        model.addAttribute("flag",1);
        return "list-users";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute CrmUser user)
    {
        userService.save(user);
        return "redirect:/list";
    }
    @PostMapping("/update")
    public String updateUser(@ModelAttribute User user,@RequestParam String role,@RequestParam Integer flag)
    {
        System.out.println(role);
        userService.update(user,role);
        System.out.println(flag);
        if(flag==1)
            return "redirect:/user";
        return "redirect:/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("userName") String username, Model model){
        User user=userService.findByUserName(username);
        model.addAttribute("user",user);
        List<Role>roles= (List<Role>) user.getRoles();
        model.addAttribute("flag",0);
        model.addAttribute("role",roles.get(0).getName());
        return "user-form";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("userName") String username)
    {
        userService.deleteByUsername(username);
        return "redirect:/list";
    }
    @GetMapping("/showFormForChangeRole")
    public String showFormForChangeRole(@RequestParam("userName") String username, Model model){
        User user=userService.findByUserName(username);
        model.addAttribute("user",user);
        model.addAttribute("role",new Role());
        return "change-role-form";
    }
    @PostMapping("/changeRole")
    public String changeRole(@ModelAttribute User user,@RequestParam String role)
    {

        userService.changeRole(role,user.getUsername());
        return "redirect:/list";
    }

    @GetMapping("/showFormForChangeDetails")
    public String showFormForChangeDetails(@RequestParam("userName") String username, Model model){
        User user=userService.findByUserName(username);
        model.addAttribute("user",user);
        List<Role>roles= (List<Role>) user.getRoles();
        model.addAttribute("flag",1);
        model.addAttribute("role",roles.get(0).getName());
        return "change-details-page";
    }
    @GetMapping("/showFormForChangePassword")
    public String showFormForChangePassword(Model model){
        model.addAttribute("pw",new ChangePassword());
        return "change-password-form";
    }
    @PostMapping("/processChangePassword")
    public String processRegistrationForm( @Valid @ModelAttribute("pw") ChangePassword password,
                                          BindingResult theBindingResult) {
        if(theBindingResult.hasErrors())
            return "change-password-form";

        return "redirect:/user";

    }

}
