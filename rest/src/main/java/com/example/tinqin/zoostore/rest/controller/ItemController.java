package com.example.tinqin.zoostore.rest.controller;

import com.example.tinqin.zoostore.API.operation.item.create.ItemCreateOperation;
import com.example.tinqin.zoostore.API.operation.item.create.ItemCreateRequest;
import com.example.tinqin.zoostore.API.operation.item.create.ItemCreateResponse;
import com.example.tinqin.zoostore.API.operation.item.getall.ItemGetAllByIdRequest;
import com.example.tinqin.zoostore.API.operation.item.getall.ItemGetAllByIdResponse;
import com.example.tinqin.zoostore.API.operation.item.getall.ItemGetAllOperation;
import com.example.tinqin.zoostore.API.operation.item.getby.id.ItemGetByIdOperation;
import com.example.tinqin.zoostore.API.operation.item.getby.id.ItemGetByIdRequest;
import com.example.tinqin.zoostore.API.operation.item.getby.id.ItemGetByIdResponse;
import com.example.tinqin.zoostore.API.operation.item.getby.title.ItemGetByTitleOperation;
import com.example.tinqin.zoostore.API.operation.item.getby.title.ItemGetByTitleRequest;
import com.example.tinqin.zoostore.API.operation.item.getby.title.ItemGetByTitleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemCreateOperation itemService;
    private final ItemGetAllOperation getAllItemsService;
    private final ItemGetByTitleOperation itemGetByTitleOperation;

    private final ItemGetByIdOperation getByIdOperation;
    @Autowired
    public ItemController(ItemCreateOperation itemService, ItemGetAllOperation getAllItemsService, ItemGetByTitleOperation itemGetByTitleOperation, ItemGetByIdOperation getByIdOperation) {
        this.itemService = itemService;
        this.getAllItemsService = getAllItemsService;
        this.itemGetByTitleOperation = itemGetByTitleOperation;
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

    @GetMapping("/title")
    public ResponseEntity<?> getItemsByTitle (@RequestParam String title, @RequestParam(defaultValue = "0") Integer page,@RequestParam(defaultValue = "10") Integer pageSize) {
        ItemGetByTitleRequest itemGetByTitleRequest = ItemGetByTitleRequest
                .builder()
                .itemTitle(title)
                .page(page)
                .size(pageSize)
                .build();
        ItemGetByTitleResponse itemGetByTitleResponse = itemGetByTitleOperation.process(itemGetByTitleRequest);
        return new ResponseEntity<>(itemGetByTitleResponse, HttpStatus.OK);
    }

}
