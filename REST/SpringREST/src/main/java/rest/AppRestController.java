package main.java.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class AppRestController {

    @RequestMapping("/hello")
    private String sayHello()
    {
        return "Hello world!";
    }
}
