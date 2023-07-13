package com.example.tinqin.zoostore.API.controller;

import com.example.tinqin.zoostore.API.request.MultimediaCreateRequest;
import com.example.tinqin.zoostore.API.request.MultimediaDeleteRequest;
import com.example.tinqin.zoostore.API.request.MultimediaUpdateRequest;
import com.example.tinqin.zoostore.API.response.MultimediaCreateResponse;
import com.example.tinqin.zoostore.API.response.MultimediaDeleteResponse;
import com.example.tinqin.zoostore.API.response.MultimediaUpdateResponse;
import com.example.tinqin.zoostore.service.MultimediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class MultimediaController {

    private final MultimediaService multimediaService;
    @Autowired
    public MultimediaController(MultimediaService multimediaService) {
        this.multimediaService = multimediaService;
    }

    @PostMapping("/multimediaCreate")
    public ResponseEntity<MultimediaCreateResponse> multimediaCreate(@RequestBody MultimediaCreateRequest multimediaCreateRequest){
        return ResponseEntity.ok(multimediaService.createMultimedia(multimediaCreateRequest));
    }

   /* @PutMapping("/updateMultimedia/{url}")
    public ResponseEntity<MultimediaUpdateResponse> multimediaUpdate(@PathVariable String url, @RequestBody MultimediaUpdateRequest multimediaUpdateRequest){
        multimediaUpdateRequest.setUrl(url);
        return ResponseEntity.ok(multimediaService.updateMultimedia(multimediaUpdateRequest));
    }*/
    @Transactional
    @DeleteMapping("/deleteMultimedia")
    public ResponseEntity<MultimediaDeleteResponse> multimediaDelete(@RequestBody MultimediaDeleteRequest multimediaDeleteRequest){
        return ResponseEntity.ok(multimediaService.deleteMultimedia(multimediaDeleteRequest));
    }
}
