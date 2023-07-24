package com.example.tinqin.zoostore.rest.controller;

import com.example.tinqin.zoostore.API.operation.multimedia.create.MultimediaCreateOperation;
import com.example.tinqin.zoostore.API.operation.multimedia.create.MultimediaCreateRequest;
import com.example.tinqin.zoostore.API.operation.multimedia.create.MultimediaCreateResponse;
import com.example.tinqin.zoostore.API.operation.multimedia.delete.MultimediaDeleteOperation;
import com.example.tinqin.zoostore.API.operation.multimedia.delete.MultimediaDeleteRequest;
import com.example.tinqin.zoostore.API.operation.multimedia.delete.MultimediaDeleteResponse;
import com.example.tinqin.zoostore.API.operation.multimedia.update.MultimediaUpdateOperation;
import com.example.tinqin.zoostore.API.operation.multimedia.update.MultimediaUpdateRequest;
import com.example.tinqin.zoostore.API.operation.multimedia.update.MultimediaUpdateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class MultimediaController {

    private final MultimediaDeleteOperation multimediaDeleteOperation;
    private final MultimediaUpdateOperation multimediaUpdateOperation;
    private final MultimediaCreateOperation multimediaCreateOperation;
    @Autowired
    public MultimediaController(MultimediaDeleteOperation multimediaDeleteOperation,
                                MultimediaUpdateOperation multimediaUpdateOperation,
                                MultimediaCreateOperation multimediaCreateOperation) {
        this.multimediaDeleteOperation = multimediaDeleteOperation;
        this.multimediaUpdateOperation = multimediaUpdateOperation;
        this.multimediaCreateOperation = multimediaCreateOperation;
    }

    @PostMapping("/multimediaCreate")
    public ResponseEntity<MultimediaCreateResponse> multimediaCreate(@RequestBody MultimediaCreateRequest multimediaCreateRequest){
        return ResponseEntity.ok(multimediaCreateOperation.process(multimediaCreateRequest));
    }

    @PatchMapping("/updateMultimedia")
    public ResponseEntity<MultimediaUpdateResponse> multimediaUpdate(@RequestBody MultimediaUpdateRequest multimediaUpdateRequest){
        return ResponseEntity.ok(multimediaUpdateOperation.process(multimediaUpdateRequest));
    }
    @Transactional
    @DeleteMapping("/deleteMultimedia")
    public ResponseEntity<MultimediaDeleteResponse> multimediaDelete(@RequestBody MultimediaDeleteRequest multimediaDeleteRequest){
        return ResponseEntity.ok(multimediaDeleteOperation.process(multimediaDeleteRequest));
    }
}
