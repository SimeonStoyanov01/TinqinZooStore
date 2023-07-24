package com.example.tinqin.zoostore.core.service.multimedia;

import com.example.tinqin.zoostore.API.operation.multimedia.delete.MultimediaDeleteOperation;
import com.example.tinqin.zoostore.API.operation.multimedia.delete.MultimediaDeleteRequest;
import com.example.tinqin.zoostore.API.operation.multimedia.delete.MultimediaDeleteResponse;
import com.example.tinqin.zoostore.core.exceptions.NoMultimediaWithSuchUrlException;
import com.example.tinqin.zoostore.persistence.entity.MultimediaEntity;
import com.example.tinqin.zoostore.persistence.repository.MultimediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MultimediaDeleteOperationProcessor implements MultimediaDeleteOperation {
    private final MultimediaRepository multimediaRepository;
    @Autowired
    public MultimediaDeleteOperationProcessor(MultimediaRepository multimediaRepository) {
        this.multimediaRepository = multimediaRepository;
    }

    @Override
    public MultimediaDeleteResponse process(MultimediaDeleteRequest operationRequest) {
        if(operationRequest.getUrl()==null||operationRequest.getUrl().trim().equals("")){
            throw new IllegalArgumentException();
        }
        MultimediaEntity multimediaEntity=multimediaRepository
                .findMultimediaEntityByUrl(operationRequest
                        .getUrl())
                .orElseThrow(NoMultimediaWithSuchUrlException::new);
        multimediaRepository.deleteMultimediaEntityByUrl(multimediaEntity.getUrl());//.deleteById(multimediaEntity.getId());

        return MultimediaDeleteResponse
                .builder()
                .multimediaID(multimediaEntity.getId())
                .url(multimediaEntity.getUrl())
                .build();
    }
}
