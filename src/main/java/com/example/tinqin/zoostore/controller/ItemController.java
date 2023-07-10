package com.example.tinqin.zoostore.controller;

import com.example.tinqin.zoostore.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;
    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    //TODO method to be reworked, this is not a real implementation.
    @GetMapping("/{string}")
    public ResponseEntity<String>getItemByID(@PathVariable String string){
        return ResponseEntity.ok(string);
    }

}
