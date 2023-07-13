package com.example.tinqin.zoostore.API.controller;

import com.example.tinqin.zoostore.API.request.GetItemByIDRequest;
import com.example.tinqin.zoostore.API.request.ItemCreateRequest;
import com.example.tinqin.zoostore.API.response.GetItemByIDResponse;
import com.example.tinqin.zoostore.API.response.ItemCreateResponse;
import com.example.tinqin.zoostore.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    //TODO method to be reworked, this is not a real implementation.
    @PostMapping
    public ResponseEntity<GetItemByIDResponse>getItemByID(@RequestBody GetItemByIDRequest getItemByIDRequest){
        return ResponseEntity.ok(itemService.getItemByID(getItemByIDRequest));
    }

    @PostMapping("/createItem")
    public ResponseEntity<ItemCreateResponse> createItem(@RequestBody ItemCreateRequest itemCreateRequest){
        return ResponseEntity.ok(itemService.createItem(itemCreateRequest));
    }

}
