package com.example.tinqin.zoostore.rest.controller;

import com.example.tinqin.zoostore.API.operation.item.getall.ItemGetAllOperation;
import com.example.tinqin.zoostore.API.operation.item.create.ItemCreateRequest;
import com.example.tinqin.zoostore.API.operation.item.create.ItemCreateResponse;
import com.example.tinqin.zoostore.API.operation.item.getall.ItemGetAllByIdRequest;
import com.example.tinqin.zoostore.API.operation.item.getall.ItemGetAllByIdResponse;
import com.example.tinqin.zoostore.API.operation.item.create.ItemCreateOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemCreateOperation itemService;
    private final ItemGetAllOperation getAllItemsService;
    @Autowired
    public ItemController(ItemCreateOperation itemService, ItemGetAllOperation getAllItemsService) {
        this.itemService = itemService;
        this.getAllItemsService = getAllItemsService;
    }

    //TODO method to be reworked, this is not a real implementation.
//    @PostMapping
//    public ResponseEntity<GetItemByIDResponse>getItemByID(@RequestBody GetItemByIDRequest getItemByIDRequest){
//        return ResponseEntity.ok(.getItemByID(getItemByIDRequest));
//    }

    @PostMapping("/createItem")
    public ResponseEntity<ItemCreateResponse> createItem(@RequestBody ItemCreateRequest itemCreateRequest){
        return ResponseEntity.ok(itemService.process(itemCreateRequest));
    }

    @GetMapping("/getAllItems")
    public ResponseEntity<ItemGetAllByIdResponse> getALlItems(ItemGetAllByIdRequest itemGetAllByIdRequest){
        return ResponseEntity.ok(getAllItemsService.process(itemGetAllByIdRequest));
    }

}
