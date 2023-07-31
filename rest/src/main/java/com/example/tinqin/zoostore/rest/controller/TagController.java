package com.example.tinqin.zoostore.rest.controller;

import com.example.tinqin.zoostore.API.operation.tag.create.TagCreateOperation;
import com.example.tinqin.zoostore.API.operation.tag.create.TagCreateRequest;
import com.example.tinqin.zoostore.API.operation.tag.create.TagCreateResponse;
import com.example.tinqin.zoostore.API.operation.tag.delete.TagDeleteOperation;
import com.example.tinqin.zoostore.API.operation.tag.delete.TagDeleteRequest;
import com.example.tinqin.zoostore.API.operation.tag.delete.TagDeleteResponse;
import com.example.tinqin.zoostore.API.operation.tag.getitemsbytag.TagGetItemsOperation;
import com.example.tinqin.zoostore.API.operation.tag.getitemsbytag.TagGetItemsRequest;
import com.example.tinqin.zoostore.API.operation.tag.getitemsbytag.TagGetItemsResponse;
import com.example.tinqin.zoostore.API.operation.tag.update.TagUpdateOperation;
import com.example.tinqin.zoostore.API.operation.tag.update.TagUpdateRequest;
import com.example.tinqin.zoostore.API.operation.tag.update.TagUpdateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/tag")
public class TagController {
    private final TagUpdateOperation updateOperation;
    private final TagCreateOperation createOperation;
    private final TagDeleteOperation deleteOperation;
    private final TagGetItemsOperation getItemsOperation;
    @Autowired
    public TagController(TagUpdateOperation updateOperation, TagCreateOperation createOperation, TagDeleteOperation deleteOperation, TagGetItemsOperation getItemsOperation) {
        this.updateOperation = updateOperation;
        this.createOperation = createOperation;
        this.deleteOperation = deleteOperation;
        this.getItemsOperation = getItemsOperation;
    }
    @PostMapping("/createTag")
    public ResponseEntity<TagCreateResponse> tagCreate(@RequestBody TagCreateRequest tagCreateRequest){
        return ResponseEntity.ok(createOperation.process(tagCreateRequest));
    }
    @PutMapping("/updateTag/{tagId}")
    public ResponseEntity<TagUpdateResponse> tagUpdate(@PathVariable UUID tagId, @RequestBody TagUpdateRequest tagUpdateRequest){
        tagUpdateRequest.setTagId(tagId);
        return ResponseEntity.ok(updateOperation.process(tagUpdateRequest));
    }
    @DeleteMapping("/deleteTag")
    public ResponseEntity<TagDeleteResponse> tagDelete(@RequestBody TagDeleteRequest tagDeleteRequest){
        return ResponseEntity.ok(deleteOperation.process(tagDeleteRequest));
    }
    @GetMapping("/tagName")
    public ResponseEntity<TagGetItemsResponse> tagGetItem
            (@RequestParam(name = "tagName") String tagName,
             @RequestParam(name = "page")Integer page,
             @RequestParam(name = "size")Integer size){
        TagGetItemsRequest tagGetItemsRequest=TagGetItemsRequest
                .builder()
                .tagTitle(tagName)
                .page(page)
                .size(size)
                .build();
        return ResponseEntity.ok(getItemsOperation.process(tagGetItemsRequest));
    }
}
