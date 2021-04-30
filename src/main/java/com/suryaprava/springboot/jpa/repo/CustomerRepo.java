package com.suryaprava.springboot.jpa.repo;

import com.suryaprava.springboot.jpa.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customer, Long> {
}
