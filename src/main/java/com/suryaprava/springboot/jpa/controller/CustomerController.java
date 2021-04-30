package com.suryaprava.springboot.jpa.controller;

import com.suryaprava.springboot.jpa.model.Customer;
import com.suryaprava.springboot.jpa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> getCustomers() {
        return new ResponseEntity<>(customerService.getCustomers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public ResponseEntity<Customer> getCustomer(@RequestParam long id) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/add", method = RequestMethod.POST)
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/update", method = RequestMethod.PUT)
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/delete", method = RequestMethod.DELETE)
    public ResponseEntity<Customer> deleteCustomer(@RequestParam long id) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
