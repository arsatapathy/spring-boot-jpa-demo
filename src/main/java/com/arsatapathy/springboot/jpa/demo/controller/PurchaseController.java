package com.arsatapathy.springboot.jpa.demo.controller;

import com.arsatapathy.springboot.jpa.demo.model.Purchase;
import com.arsatapathy.springboot.jpa.demo.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @RequestMapping(value = "/purchases", method = RequestMethod.GET)
    public ResponseEntity<List<Purchase>> getPurchase() {
        return new ResponseEntity<>(purchaseService.getPurchase(), HttpStatus.OK);
    }

    @RequestMapping(value = "/purchase", method = RequestMethod.POST)
    public ResponseEntity<Purchase> purchase(@RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseService.purchase(purchase), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/purchase/remove", method = RequestMethod.DELETE)
    public ResponseEntity<String> removePurchase(@RequestParam(value = "id") Long purchaseId) {
        purchaseService.removePurchase(purchaseId);
        return new ResponseEntity<>("Purchase removed!", HttpStatus.OK);
    }
}
