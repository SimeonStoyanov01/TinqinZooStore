package com.example.tinqin.zoostore.rest.controller;

import com.example.tinqin.zoostore.API.operation.item.create.ItemCreateOperation;
import com.example.tinqin.zoostore.API.operation.item.create.ItemCreateRequest;
import com.example.tinqin.zoostore.API.operation.item.create.ItemCreateResponse;
import com.example.tinqin.zoostore.API.operation.item.getall.ItemGetAllByIdRequest;
import com.example.tinqin.zoostore.API.operation.item.getall.ItemGetAllByIdResponse;
import com.example.tinqin.zoostore.API.operation.item.getall.ItemGetAllOperation;
import com.example.tinqin.zoostore.API.operation.item.getbyid.ItemGetByIdOperation;
import com.example.tinqin.zoostore.API.operation.item.getbyid.ItemGetByIdRequest;
import com.example.tinqin.zoostore.API.operation.item.getbyid.ItemGetByIdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemCreateOperation itemService;
    private final ItemGetAllOperation getAllItemsService;

    private final ItemGetByIdOperation getByIdOperation;
    @Autowired
    public ItemController(ItemCreateOperation itemService, ItemGetAllOperation getAllItemsService, ItemGetByIdOperation getByIdOperation) {
        this.itemService = itemService;
        this.getAllItemsService = getAllItemsService;
        this.getByIdOperation = getByIdOperation;
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

    @GetMapping("/{id}")
    public ResponseEntity<ItemGetByIdResponse> getItemById(@PathVariable String id){
        ItemGetByIdRequest request=ItemGetByIdRequest.builder().id(id).build();
        return ResponseEntity.ok(getByIdOperation.process(request));
    }

}
