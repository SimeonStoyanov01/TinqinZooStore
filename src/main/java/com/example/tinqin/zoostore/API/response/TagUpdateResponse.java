package com.example.tinqin.zoostore.API.response;

import lombok.*;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TagUpdateResponse {

    private UUID tagId;
    private String title;

}
