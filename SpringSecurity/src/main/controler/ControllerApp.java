package main.controler;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerApp {

    @GetMapping("/")
    public String showHome()
    {
        return "home-page";
    }
    @GetMapping("/leaders")
    public String showLeaders()
    {
        return "leaders-page";
    }

    @GetMapping("/systems")
    public String showSystems()
    {
        return "systems-page";
    }
    @GetMapping("/access-denied")
    public String showDeniedPage()
    {
        return "access-denied-page";
    }
}
