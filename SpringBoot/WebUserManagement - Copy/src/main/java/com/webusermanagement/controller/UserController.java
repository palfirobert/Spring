package com.webusermanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {

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
        return ("admin-page");
    }

}
