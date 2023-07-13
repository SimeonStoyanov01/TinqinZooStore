package com.example.tinqin.zoostore.service.impl;

import com.example.tinqin.zoostore.API.request.MultimediaCreateRequest;
import com.example.tinqin.zoostore.API.request.MultimediaDeleteRequest;
import com.example.tinqin.zoostore.API.request.MultimediaUpdateRequest;
import com.example.tinqin.zoostore.API.response.MultimediaCreateResponse;
import com.example.tinqin.zoostore.API.response.MultimediaDeleteResponse;
import com.example.tinqin.zoostore.API.response.MultimediaUpdateResponse;
import com.example.tinqin.zoostore.data.entity.MultimediaEntity;
import com.example.tinqin.zoostore.data.repository.MultimediaRepository;
import com.example.tinqin.zoostore.exceptions.MultimediaExistsException;
import com.example.tinqin.zoostore.exceptions.NoMultimediaWithSuchUrlException;
import com.example.tinqin.zoostore.service.MultimediaService;
import org.springframework.stereotype.Service;

@Service
public class MultimediaServiceImpl implements MultimediaService {

    private final MultimediaRepository multimediaRepository;

    public MultimediaServiceImpl(MultimediaRepository multimediaRepository) {
        this.multimediaRepository = multimediaRepository;
    }

    @Override
    public MultimediaCreateResponse createMultimedia(MultimediaCreateRequest multimediaCreateRequest) {
        if(multimediaCreateRequest.getUrl()==null||multimediaCreateRequest.getUrl().trim().equals("")){
            throw new IllegalArgumentException();
        }
        if(this.multimediaRepository.findMultimediaEntityByUrl(multimediaCreateRequest.getUrl()).isPresent()){
            throw new MultimediaExistsException();
        }
        MultimediaEntity multimediaEntity=new MultimediaEntity();
        multimediaEntity.setUrl(multimediaCreateRequest.getUrl());
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

    @Override
    public MultimediaUpdateResponse updateMultimedia(MultimediaUpdateRequest multimediaUpdateRequest) {
        if(multimediaUpdateRequest.getUrl()==null||multimediaUpdateRequest.getUrl().trim().equals("")){
            throw new IllegalArgumentException();
        }
        if(this.multimediaRepository.findMultimediaEntityByUrl(multimediaUpdateRequest.getUrl()).isPresent()){
            throw new MultimediaExistsException();
        }
        MultimediaEntity multimediaEntity=multimediaRepository
                .findMultimediaEntityByUrl(multimediaUpdateRequest
                .getUrl())
                .orElseThrow(NoMultimediaWithSuchUrlException::new);
        multimediaEntity.setUrl(multimediaUpdateRequest.getUrl());
        MultimediaEntity updatedEntity = multimediaRepository.save(multimediaEntity);
        MultimediaUpdateResponse multimediaUpdateResponse=
                MultimediaUpdateResponse
                        .builder()
                        .multimediaID(updatedEntity.getId())
                        .url(updatedEntity.getUrl())
                        .build();
        return multimediaUpdateResponse;
    }

    @Override
    public MultimediaDeleteResponse deleteMultimedia(MultimediaDeleteRequest multimediaDeleteRequest) {
        if(multimediaDeleteRequest.getUrl()==null||multimediaDeleteRequest.getUrl().trim().equals("")){
            throw new IllegalArgumentException();
        }
        MultimediaEntity multimediaEntity=multimediaRepository
                .findMultimediaEntityByUrl(multimediaDeleteRequest
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
