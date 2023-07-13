package com.example.tinqin.zoostore.API.response;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemCreateResponse {
    private UUID id;
    private String title;
    private Boolean isArchived;
}
