package com.luv2code.springdemo.controler;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.rest.CustomerNotFoundException;
import com.luv2code.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")  //sa luam toti clientii
    public List<Customer> getCustomers()
    {
        return customerService.getCustomers();
    }

    @GetMapping("/customers/{customerId}")  //sa luam un client
    public Customer getCustomer(@PathVariable int customerId)
    {   if(customerId>customerService.getCustomers().size())
        throw new CustomerNotFoundException("Customer not found with id "+customerId);

        return customerService.getCustomer(customerId);
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer)
    {
        customer.setId(0); //trebuie sa punem pe 0 fiindca e metoda saveorupdate si daca e 0 da insert
        customerService.saveCustomer(customer);
        return customer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer)
    {
        customerService.saveCustomer(customer);
        return customer;
    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId)
    {   if(customerId>customerService.getCustomers().size())
        throw new CustomerNotFoundException("Customer not found with id "+customerId);

        customerService.deleteCustomer(customerId);
        return "Deleted customer id "+customerId;
    }

}
