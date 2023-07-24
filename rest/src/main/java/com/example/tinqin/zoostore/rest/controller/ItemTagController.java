package com.example.tinqin.zoostore.rest.controller;

import com.example.tinqin.zoostore.API.operation.itemtag.addtag.ItemAddTagOperation;
import com.example.tinqin.zoostore.API.operation.itemtag.addtag.ItemTagAddRequest;
import com.example.tinqin.zoostore.API.operation.itemtag.addtag.ItemTagAddResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemTagController {
    private final ItemAddTagOperation itemTagService;
    @Autowired
    public ItemTagController(ItemAddTagOperation itemTagService) {
        this.itemTagService = itemTagService;
    }
    @PostMapping("/addTag")
    public ResponseEntity<ItemTagAddResponse> addTag(@RequestBody ItemTagAddRequest itemTagAddRequest){
        return ResponseEntity.ok(itemTagService.process(itemTagAddRequest));
    }
}
