package com.example.tinqin.zoostore.core.service.tag;

import com.example.tinqin.zoostore.API.operation.tag.delete.TagDeleteOperation;
import com.example.tinqin.zoostore.API.operation.tag.delete.TagDeleteRequest;
import com.example.tinqin.zoostore.API.operation.tag.delete.TagDeleteResponse;
import com.example.tinqin.zoostore.persistence.entity.TagEntity;
import com.example.tinqin.zoostore.persistence.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TagDeleteOperationProcessor implements TagDeleteOperation {

    private final TagRepository tagRepository;
    @Autowired
    public TagDeleteOperationProcessor(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    @Transactional
    public TagDeleteResponse process(TagDeleteRequest operationRequest) {
        if(operationRequest.getTitle()==null||operationRequest.getTitle().trim().equals("")){
            throw new IllegalArgumentException();
        }
        TagEntity tag = tagRepository.findTagEntityByTitle(operationRequest.getTitle()).get();
        tagRepository.deleteById(tag.getId());

        return TagDeleteResponse.builder()
                .tagId(tag.getId())
                .title(tag.getTitle())
                .build();
    }
}
