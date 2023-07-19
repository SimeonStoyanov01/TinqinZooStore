package com.example.tinqin.zoostore.rest.controller;

import com.example.tinqin.zoostore.API.operation.itemmultimedia.add.ItemMultimediaAddRequest;
import com.example.tinqin.zoostore.API.operation.itemmultimedia.add.ItemMultimediaAddResponse;
import com.example.tinqin.zoostore.API.operation.itemmultimedia.add.ItemAddMultimediaOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemMultimediaController {

    private final ItemAddMultimediaOperation itemMultimediaService;

    public ItemMultimediaController(ItemAddMultimediaOperation itemMultimediaService) {
        this.itemMultimediaService = itemMultimediaService;
    }

    @PostMapping("/addMultimedia")
    public ResponseEntity<ItemMultimediaAddResponse> addMultimedia(@RequestBody ItemMultimediaAddRequest itemMultimediaAddRequest){
        return ResponseEntity.ok(itemMultimediaService.process(itemMultimediaAddRequest));
    }
}
