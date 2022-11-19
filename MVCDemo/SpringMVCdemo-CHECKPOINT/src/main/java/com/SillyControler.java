package main.java.com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/silly")
public class SillyControler {

    @RequestMapping("/showForm")
    public String displayForm()
    {
        return "silly";
    }

}
