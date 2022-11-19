package main.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showCustomLoginPage")
    public String showCustomLoginPage()
    {
        return "fancy-login";
    }
}
