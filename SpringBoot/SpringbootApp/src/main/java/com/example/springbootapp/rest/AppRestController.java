package com.example.springbootapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class AppRestController {

    @Value("${team.name}")
    private String teamName;

    @Value("${coach.name}")
    private String coachName;

    @GetMapping("/")
    public String sayHello()
    {
        return "Hello World! Time on server is "+ LocalDateTime.now();
    }

    @GetMapping("/workout")
    public String getDailyWorkout()
    {
        return "WORKOUT!!!"+coachName;
    }
}
