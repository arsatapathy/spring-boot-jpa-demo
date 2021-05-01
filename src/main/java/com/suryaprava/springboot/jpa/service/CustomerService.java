package com.suryaprava.springboot.jpa.service;

import com.suryaprava.springboot.jpa.model.Customer;
import com.suryaprava.springboot.jpa.repo.CustomerRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public List<Customer> getCustomers() {
        List<Customer> customers = new LinkedList<>();
        customerRepo.findAll().forEach(customers::add);
        return customers;
    }

    public Customer addCustomer(Customer customer) {
        return customerRepo.save(customer);
    }
}
