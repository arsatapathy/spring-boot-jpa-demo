package com.arsatapathy.springboot.jpa.demo.repo;

import com.arsatapathy.springboot.jpa.demo.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customer, Long> {
}
