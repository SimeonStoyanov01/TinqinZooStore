package com.example.tinqin.zoostore.core.service.multimedia;

import com.example.tinqin.zoostore.API.operation.multimedia.create.MultimediaCreateOperation;
import com.example.tinqin.zoostore.API.operation.multimedia.create.MultimediaCreateRequest;
import com.example.tinqin.zoostore.API.operation.multimedia.create.MultimediaCreateResponse;
import com.example.tinqin.zoostore.core.exceptions.MultimediaExistsException;
import com.example.tinqin.zoostore.persistence.entity.MultimediaEntity;
import com.example.tinqin.zoostore.persistence.repository.MultimediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MultimediaCreateOperationProcessor implements MultimediaCreateOperation {
    private final MultimediaRepository multimediaRepository;
    @Autowired
    public MultimediaCreateOperationProcessor(MultimediaRepository multimediaRepository) {
        this.multimediaRepository = multimediaRepository;
    }


    @Override
    public MultimediaCreateResponse process(MultimediaCreateRequest operationRequest) {
        if(operationRequest.getUrl()==null||operationRequest.getUrl().trim().equals("")){
            throw new IllegalArgumentException();
        }
        if(this.multimediaRepository.findMultimediaEntityByUrl(operationRequest.getUrl()).isPresent()){
            throw new MultimediaExistsException();
        }
        MultimediaEntity multimediaEntity=new MultimediaEntity();
        multimediaEntity.setUrl(operationRequest.getUrl());
        multimediaEntity.setIsArchived(false);
        this.multimediaRepository.save(multimediaEntity);
        MultimediaCreateResponse multimediaCreateResponse=MultimediaCreateResponse
                .builder()
                .multimediaID(multimediaEntity.getId())
                .url(multimediaEntity.getUrl())
                .is_archived(multimediaEntity.getIsArchived())
                .build();

        return multimediaCreateResponse;
    }
}
