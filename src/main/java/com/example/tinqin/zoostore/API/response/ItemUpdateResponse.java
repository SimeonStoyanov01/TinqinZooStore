package com.example.tinqin.zoostore.API.response;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemUpdateResponse {
    private UUID id;
    private String title;
}
