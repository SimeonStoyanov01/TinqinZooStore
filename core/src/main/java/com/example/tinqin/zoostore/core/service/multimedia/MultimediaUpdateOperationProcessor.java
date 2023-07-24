package com.example.tinqin.zoostore.core.service.multimedia;

import com.example.tinqin.zoostore.API.operation.multimedia.update.MultimediaUpdateOperation;
import com.example.tinqin.zoostore.API.operation.multimedia.update.MultimediaUpdateRequest;
import com.example.tinqin.zoostore.API.operation.multimedia.update.MultimediaUpdateResponse;
import com.example.tinqin.zoostore.core.exceptions.MultimediaExistsException;
import com.example.tinqin.zoostore.core.exceptions.NoMultimediaWithSuchUrlException;
import com.example.tinqin.zoostore.persistence.entity.MultimediaEntity;
import com.example.tinqin.zoostore.persistence.repository.MultimediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MultimediaUpdateOperationProcessor implements MultimediaUpdateOperation {
    private final MultimediaRepository multimediaRepository;
    @Autowired
    public MultimediaUpdateOperationProcessor(MultimediaRepository multimediaRepository) {
        this.multimediaRepository = multimediaRepository;
    }

    @Override
    public MultimediaUpdateResponse process(MultimediaUpdateRequest operationRequest) {
        if(operationRequest.getUrl()==null||operationRequest.getUrl().trim().equals("")){
            throw new IllegalArgumentException();
        }
        if(this.multimediaRepository.findMultimediaEntityByUrl(operationRequest.getUrl()).isPresent()){
            throw new MultimediaExistsException();
        }
        MultimediaEntity multimediaEntity=multimediaRepository
                .findMultimediaEntityByUrl(operationRequest
                        .getUrl())
                .orElseThrow(NoMultimediaWithSuchUrlException::new);
        multimediaEntity.setUrl(operationRequest.getUrl());
        MultimediaEntity updatedEntity = multimediaRepository.save(multimediaEntity);
        return MultimediaUpdateResponse
                .builder()
                .multimediaID(updatedEntity.getId())
                .url(updatedEntity.getUrl())
                .build();
    }
}
