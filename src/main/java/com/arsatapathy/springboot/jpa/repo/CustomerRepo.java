package com.arsatapathy.springboot.jpa.repo;

import com.arsatapathy.springboot.jpa.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customer, Long> {
}
