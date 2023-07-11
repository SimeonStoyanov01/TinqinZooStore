package com.example.tinqin.zoostore.API.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class TagUpdateRequest {
    private UUID tagId;
    private String title;
}
