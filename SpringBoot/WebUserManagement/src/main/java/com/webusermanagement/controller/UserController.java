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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
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
    public String listEmployees(Model model){
        List<User> users=userService.findAll();
        List<User>list=getUsersWithoutOwner(users);
        model.addAttribute("users",list);
        model.addAttribute("flag",1);
        return "list-users";
    }
    private List <User>getUsersWithoutOwner(List<User>users)
    {List<User>usr=new ArrayList<>();
        for(User aux:users)
        {   if(!aux.getRoles().stream().findFirst().get().getName().equals("ROLE_OWNER")) {
            usr.add(aux);

        }
        }
        return usr;
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
        List<Role>roles= (List<Role>) user.getRoles();
        List<String>select=new ArrayList<>();
        System.out.println(roles.get(0).toString());
        if(roles.get(0).getName().equals("ROLE_USER"))
        {

            select.add("USER");select.add("ADMIN");
        }
        else
        {
            select.add("ADMIN"); select.add("USER");
        }
        model.addAttribute("options",select);
        return "change-role-form";
    }
    @PostMapping("/changeRole")
    public String changeRole(@ModelAttribute User user,@RequestParam String role)
    {
        
        userService.changeRole("ROLE_"+role,user.getUsername());
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
    public String processRegistrationForm(@Valid @ModelAttribute("pw") ChangePassword password, RedirectAttributes redirectAttributes,
                                          BindingResult theBindingResult) {
        if(theBindingResult.hasErrors())
            return "change-password-form";
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user=userService.findByUserName(auth.getName());
        userService.changePassword(user,password.getPassword());
        redirectAttributes.addFlashAttribute("success", "Password changed!");
        return "redirect:/user";

    }


    @GetMapping("/processUserById")
    public String processUserRest(@RequestParam(value = "Id",required = false) Long id,RedirectAttributes redirectAttributes,Model model)
    {
        if(id==null) {
            redirectAttributes.addFlashAttribute("message", "Add a number");
            return "redirect:/owner";
        }

        User user=userService.findById(id);
        if(user==null) {
            redirectAttributes.addFlashAttribute("message", "User not found");
            return "redirect:/owner";
        }
        return "redirect:/rest/users/id/"+id;
    }


}
