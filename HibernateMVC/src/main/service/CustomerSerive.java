package main.service;


import main.entity.Customer;

import java.util.List;

public interface CustomerSerive {

    public List<Customer> getCustomers();
    public void saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);
}
