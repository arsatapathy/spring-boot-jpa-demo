package com.arsatapathy.springboot.jpa.demo.service;

import com.arsatapathy.springboot.jpa.demo.model.Purchase;
import com.arsatapathy.springboot.jpa.demo.repo.PurchaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepo purchaseRepo;

    public List<Purchase> getPurchase() {
        List<Purchase> purchases = new LinkedList<>();

        purchaseRepo.findAll().forEach(purchases::add);

        return purchases;
    }

    public Purchase purchase(Purchase purchase) {

        purchase.getItems().forEach(item -> {
           purchase.setPurchaseTotal(purchase.getPurchaseTotal() + item.getItemPrice());
        });

        return purchaseRepo.save(purchase);
    }

    public void removePurchase(Long purchaseId) {
        purchaseRepo.deleteById(purchaseId);
    }
}
