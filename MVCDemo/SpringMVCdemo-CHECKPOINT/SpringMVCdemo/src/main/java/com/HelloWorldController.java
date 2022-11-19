package main.java.com;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")//asta in caz de exista mai multe controlere cu aceeasi nume de request mapping sa nu fie ambiguu
public class HelloWorldController {

    @RequestMapping("/showForm") //asta e pt html pagina urmatoare
    public String showForm()
    {
        return "helloWorldForm"; //asta e sa sa trimita implementarea la view pt implementarea html a paginii
    }

    @RequestMapping("/processForm")
    public String processForm()
    {
        return "helloworld";
    }


    @RequestMapping("/processFormV2")
    public String letsShout(HttpServletRequest request, Model model){//intra la module si baga tomcat ca dependenta library
        String name=request.getParameter("studentName");
        name=name.toUpperCase();
        model.addAttribute("message",name);
        return "helloworld";
    }

    @RequestMapping("/processFormV3")
    public String letsShoutV2(@RequestParam("studentName") String name, HttpServletRequest request, Model model){ //se ia parametrul automat
        name=name.toUpperCase();
        model.addAttribute("message",name);
        return "helloworld";
    }

}
