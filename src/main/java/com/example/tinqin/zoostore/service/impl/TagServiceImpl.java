package com.example.tinqin.zoostore.service.impl;

import com.example.tinqin.zoostore.API.request.TagCreateRequest;
import com.example.tinqin.zoostore.API.request.TagDeleteRequest;
import com.example.tinqin.zoostore.API.request.TagUpdateRequest;
import com.example.tinqin.zoostore.API.response.TagCreateResponse;
import com.example.tinqin.zoostore.API.response.TagDeleteResponse;
import com.example.tinqin.zoostore.API.response.TagUpdateResponse;
import com.example.tinqin.zoostore.data.entity.TagEntity;
import com.example.tinqin.zoostore.data.repository.TagRepository;
import com.example.tinqin.zoostore.exceptions.TagExistsException;
import com.example.tinqin.zoostore.service.TagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.HTML;
import java.util.List;
import java.util.UUID;
@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }
    @Override
    public TagCreateResponse createTag(TagCreateRequest tagCreateRequest) {
        if(tagCreateRequest.getTitle()==null||tagCreateRequest.getTitle().trim().equals("")){
            throw new IllegalArgumentException();
        }
        if(this.tagRepository.findTagEntityByTitle(tagCreateRequest.getTitle()).isPresent()){
            throw new TagExistsException();
        }
        TagEntity tagEntity = new TagEntity();
        tagEntity.setTitle(tagCreateRequest.getTitle());
        this.tagRepository.save(tagEntity);
        TagCreateResponse tagCreateResponse=TagCreateResponse
                .builder()
                .tagID(tagEntity.getId())
                .title(tagEntity.getTitle())
                .build();
        return tagCreateResponse;
    }

    @Override
    public TagUpdateResponse updateTag(TagUpdateRequest tagUpdateRequest) {
        if(tagUpdateRequest.getTitle()==null||tagUpdateRequest.getTitle().trim().equals("")){
            throw new IllegalArgumentException();
        }
        if(this.tagRepository.findTagEntityByTitle(tagUpdateRequest.getTitle()).isPresent()){
            throw new TagExistsException();
        }
        TagEntity tagEntity = tagRepository.findById(tagUpdateRequest.getTagId()).orElse(null);
        tagEntity.setTitle(tagUpdateRequest.getTitle());
        TagEntity updatedEntity = tagRepository.save(tagEntity);
        TagUpdateResponse tagUpdateResponse = TagUpdateResponse
                .builder()
                .tagId(updatedEntity.getId())
                .title(updatedEntity.getTitle())
                .build();
        return tagUpdateResponse;
    }

    @Override
    @Transactional
    public TagDeleteResponse deleteTag(TagDeleteRequest tagDeleteRequest) {
        if(tagDeleteRequest.getTitle()==null||tagDeleteRequest.getTitle().trim().equals("")){
            throw new IllegalArgumentException();
        }
        TagEntity tag = tagRepository.findTagEntityByTitle(tagDeleteRequest.getTitle()).get();
        tagRepository.deleteById(tag.getId());

        return TagDeleteResponse.builder()
                .tagId(tag.getId())
                .title(tag.getTitle())
                .build();
    }
}
