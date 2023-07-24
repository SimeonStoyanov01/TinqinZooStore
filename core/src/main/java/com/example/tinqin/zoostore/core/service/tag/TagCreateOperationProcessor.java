package com.example.tinqin.zoostore.core.service.tag;

import com.example.tinqin.zoostore.API.operation.tag.create.TagCreateOperation;
import com.example.tinqin.zoostore.API.operation.tag.create.TagCreateRequest;
import com.example.tinqin.zoostore.API.operation.tag.create.TagCreateResponse;
import com.example.tinqin.zoostore.core.exceptions.TagExistsException;
import com.example.tinqin.zoostore.persistence.entity.TagEntity;
import com.example.tinqin.zoostore.persistence.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagCreateOperationProcessor implements TagCreateOperation {
    private final TagRepository tagRepository;
    @Autowired
    public TagCreateOperationProcessor(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public TagCreateResponse process(TagCreateRequest operationRequest) {
        if(operationRequest.getTitle()==null||operationRequest.getTitle().trim().equals("")){
            throw new IllegalArgumentException();
        }
        if(this.tagRepository.findTagEntityByTitle(operationRequest.getTitle()).isPresent()){
            throw new TagExistsException();
        }
        TagEntity tagEntity = new TagEntity();
        tagEntity.setTitle(operationRequest.getTitle());
        tagEntity.setIsArchived(false);
        this.tagRepository.save(tagEntity);
        return TagCreateResponse
                .builder()
                .tagID(tagEntity.getId())
                .title(tagEntity.getTitle())
                .is_archived(tagEntity.getIsArchived())
                .build();
    }
}
