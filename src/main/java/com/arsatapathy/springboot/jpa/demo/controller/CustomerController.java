package com.arsatapathy.springboot.jpa.demo.controller;

import com.arsatapathy.springboot.jpa.demo.model.Customer;
import com.arsatapathy.springboot.jpa.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> getCustomers() {
        return new ResponseEntity<>(customerService.getCustomers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public ResponseEntity<Optional<Customer>> getCustomer(@RequestParam(value = "id") long id) {
        return new ResponseEntity<>(customerService.getCustomer(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/add", method = RequestMethod.POST)
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/update", method = RequestMethod.PUT)
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.updateCustomer(customer), HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/delete", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCustomer(@RequestParam(value = "id") long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>("Customer deleted!", HttpStatus.OK);
    }

}
