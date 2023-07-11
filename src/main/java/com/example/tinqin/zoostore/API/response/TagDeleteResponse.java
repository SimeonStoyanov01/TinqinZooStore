package com.example.tinqin.zoostore.API.response;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TagDeleteResponse {
    private UUID tagId;
    private String title;
}
