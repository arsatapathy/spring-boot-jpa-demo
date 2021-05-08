package com.arsatapathy.springboot.jpa.demo.repo;

import com.arsatapathy.springboot.jpa.demo.model.Purchase;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseRepo extends CrudRepository<Purchase, Long> {

}
