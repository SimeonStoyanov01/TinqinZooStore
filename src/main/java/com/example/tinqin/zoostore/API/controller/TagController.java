package com.example.tinqin.zoostore.API.controller;

import com.example.tinqin.zoostore.API.request.TagCreateRequest;
import com.example.tinqin.zoostore.API.request.TagDeleteRequest;
import com.example.tinqin.zoostore.API.request.TagUpdateRequest;
import com.example.tinqin.zoostore.API.response.TagCreateResponse;
import com.example.tinqin.zoostore.API.response.TagDeleteResponse;
import com.example.tinqin.zoostore.API.response.TagUpdateResponse;
import com.example.tinqin.zoostore.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController()
public class TagController {
    private final TagService tagService;
    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping("/createTag")
    public ResponseEntity<TagCreateResponse> tagCreate(@RequestBody TagCreateRequest tagCreateRequest){
        return ResponseEntity.ok(tagService.createTag(tagCreateRequest));
    }

    @PutMapping("/updateTag/{tagId}")
    public ResponseEntity<TagUpdateResponse> tagUpdate(@PathVariable UUID tagId, @RequestBody TagUpdateRequest tagUpdateRequest){
        tagUpdateRequest.setTagId(tagId);
        return ResponseEntity.ok(tagService.updateTag(tagUpdateRequest));
    }

    @DeleteMapping("/deleteTag")
    public ResponseEntity<TagDeleteResponse> tagDelete(@RequestBody TagDeleteRequest tagDeleteRequest){
        return ResponseEntity.ok(tagService.deleteTag(tagDeleteRequest));
    }


}
