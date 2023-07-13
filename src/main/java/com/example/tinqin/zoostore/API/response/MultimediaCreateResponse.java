package com.example.tinqin.zoostore.API.response;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MultimediaCreateResponse {
    private UUID multimediaID;
    private String url;
    private Boolean is_archived;
}
