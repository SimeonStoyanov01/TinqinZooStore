package com.example.tinqin.zoostore.service;

import com.example.tinqin.zoostore.API.request.TagCreateRequest;
import com.example.tinqin.zoostore.API.request.TagDeleteRequest;
import com.example.tinqin.zoostore.API.request.TagUpdateRequest;
import com.example.tinqin.zoostore.API.response.TagCreateResponse;
import com.example.tinqin.zoostore.API.response.TagDeleteResponse;
import com.example.tinqin.zoostore.API.response.TagUpdateResponse;

public interface TagService {

    TagCreateResponse createTag(TagCreateRequest tagCreateRequest);
    TagUpdateResponse updateTag(TagUpdateRequest tagUpdateRequest);

    TagDeleteResponse deleteTag(TagDeleteRequest tagDeleteRequest);
}
