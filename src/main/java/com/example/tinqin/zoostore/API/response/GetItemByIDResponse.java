package com.example.tinqin.zoostore.API.response;

import lombok.*;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GetItemByIDResponse {
    private UUID id;
    private String title;
}
