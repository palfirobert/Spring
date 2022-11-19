package main.controller;


import main.dao.CustomerDAO;
import main.entity.Customer;
import main.service.CustomerSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerSerive customerSerive;

    @GetMapping("/list") //va raspunde doar la get methods
    public String listCustomers(Model model) {
        List<Customer> customers = customerSerive.getCustomers();

        model.addAttribute("customers", customers);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer)
    {   customerSerive.saveCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
        Customer customer =customerSerive.getCustomer(id);
        model.addAttribute("customer",customer);
        return "customer-form";
    }
    @GetMapping ("/deleteCustomer")
    public String deleteCustomer(@RequestParam("customerId") int id,Model model)
    {
        customerSerive.deleteCustomer(id);
        return "redirect:/customer/list";
    }
}
