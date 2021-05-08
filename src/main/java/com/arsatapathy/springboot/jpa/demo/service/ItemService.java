package com.arsatapathy.springboot.jpa.demo.service;

import com.arsatapathy.springboot.jpa.demo.model.Item;
import com.arsatapathy.springboot.jpa.demo.model.Purchase;
import com.arsatapathy.springboot.jpa.demo.repo.ItemRepo;
import com.arsatapathy.springboot.jpa.demo.repo.PurchaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private PurchaseRepo purchaseRepo;

    public List<Item> getItems() {
        List<Item> items = new LinkedList<>();

        itemRepo.findAll().forEach(items::add);

        return items;
    }

    public Item addItem(Item item) {
        Optional<Purchase> optionalPurchase = purchaseRepo.findById(item.getPurchase().getPurchaseId());

        Purchase purchase = optionalPurchase.orElse(null);
        assert purchase != null;
        purchase.setPurchaseTotal(purchase.getPurchaseTotal() + item.getItemPrice());

        purchaseRepo.save(purchase);

        return itemRepo.save(item);
    }

    public void removeItem(Long itemId) {
        itemRepo.deleteById(itemId);
    }

}
