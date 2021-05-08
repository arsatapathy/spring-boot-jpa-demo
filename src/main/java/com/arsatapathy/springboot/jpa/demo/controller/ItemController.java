package com.arsatapathy.springboot.jpa.demo.controller;

import com.arsatapathy.springboot.jpa.demo.model.Item;
import com.arsatapathy.springboot.jpa.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public ResponseEntity<List<Item>> getItems() {
        return new ResponseEntity<>(itemService.getItems(), HttpStatus.OK);
    }

    @RequestMapping(value = "/item/add", method = RequestMethod.POST)
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        return new ResponseEntity<>(itemService.addItem(item), HttpStatus.OK);
    }

    @RequestMapping(value = "/item/remove", method = RequestMethod.DELETE)
    public ResponseEntity<String> removeItem(@RequestParam(value = "id") Long itemId) {
        itemService.removeItem(itemId);
        return new ResponseEntity<>("Item removed!", HttpStatus.OK);
    }

}
