package com.example.tinqin.zoostore.service;

import com.example.tinqin.zoostore.API.request.MultimediaCreateRequest;
import com.example.tinqin.zoostore.API.request.MultimediaDeleteRequest;
import com.example.tinqin.zoostore.API.request.MultimediaUpdateRequest;
import com.example.tinqin.zoostore.API.response.MultimediaCreateResponse;
import com.example.tinqin.zoostore.API.response.MultimediaDeleteResponse;
import com.example.tinqin.zoostore.API.response.MultimediaUpdateResponse;

public interface MultimediaService {
    MultimediaCreateResponse createMultimedia(MultimediaCreateRequest multimediaCreateRequest);
    MultimediaUpdateResponse updateMultimedia(MultimediaUpdateRequest multimediaUpdateRequest);
    MultimediaDeleteResponse deleteMultimedia(MultimediaDeleteRequest multimediaDeleteRequest);

}
