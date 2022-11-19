package com.webusermanagement.controller;

import com.webusermanagement.entity.CrmUser;
import com.webusermanagement.entity.MyUserDetails;
import com.webusermanagement.entity.Role;
import com.webusermanagement.entity.User;
import com.webusermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String user()
    {
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
    public String updateUser(@ModelAttribute User user)
    {
        userService.update(user);
        return "redirect:/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("userName") String username, Model model){
        User user=userService.findByUserName(username);
        model.addAttribute("user",user);
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
        System.out.println(role);
        userService.changeRole(role,user.getUsername());
        return "redirect:/list";
    }


}
