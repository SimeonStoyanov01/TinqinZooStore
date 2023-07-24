package com.example.tinqin.zoostore.core.service.tag;

import com.example.tinqin.zoostore.API.operation.tag.update.TagUpdateOperation;
import com.example.tinqin.zoostore.API.operation.tag.update.TagUpdateRequest;
import com.example.tinqin.zoostore.API.operation.tag.update.TagUpdateResponse;
import com.example.tinqin.zoostore.core.exceptions.NoTagWithSuchIdException;
import com.example.tinqin.zoostore.core.exceptions.TagExistsException;
import com.example.tinqin.zoostore.persistence.entity.TagEntity;
import com.example.tinqin.zoostore.persistence.repository.TagRepository;
import org.springframework.stereotype.Service;

@Service
public class TagUpdateOperationProcessor implements TagUpdateOperation {
    private final TagRepository tagRepository;

    public TagUpdateOperationProcessor(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public TagUpdateResponse process(TagUpdateRequest operationRequest) {
        if(operationRequest.getTitle()==null||operationRequest.getTitle().trim().equals("")){
            throw new IllegalArgumentException();
        }
        if(this.tagRepository.findTagEntityByTitle(operationRequest.getTitle()).isPresent()){
            throw new TagExistsException();
        }
        TagEntity tagEntity = tagRepository.findById(operationRequest.getTagId()).orElseThrow(NoTagWithSuchIdException::new);
        tagEntity.setTitle(operationRequest.getTitle());
        TagEntity updatedEntity = tagRepository.save(tagEntity);
        return TagUpdateResponse
                .builder()
                .tagId(updatedEntity.getId())
                .title(updatedEntity.getTitle())
                .build();
    }
}
