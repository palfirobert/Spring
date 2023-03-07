package com.webusermanagement.controller;

import com.webusermanagement.entity.User;
import com.webusermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> findUsers()
    {
        return userService.findAll();
    }
    @GetMapping("/users/{userUsername}")
    public User getUser(@PathVariable String userUsername)
    {
        User user=userService.findByUserName(userUsername);
        if(user==null)
            throw new RuntimeException("User not found..");
        return user;
    }

    @GetMapping("/users/id/{id}")
    public User getUserById(@PathVariable Long id)
    {
        User user=userService.findById(id);
        if(user==null)
            throw new RuntimeException("User not found..");
        return user;
    }
}
