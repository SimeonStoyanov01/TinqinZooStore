package com.example.tinqin.zoostore.API.response;

import lombok.*;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TagCreateResponse {
    private UUID tagID;
    private String title;
    private Boolean is_archived;
}
