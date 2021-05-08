package com.arsatapathy.springboot.jpa.demo.repo;

import com.arsatapathy.springboot.jpa.demo.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepo extends CrudRepository<Item, Long> {
}
