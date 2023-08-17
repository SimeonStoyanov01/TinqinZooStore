package com.example.tinqin.zoostore.API.operation.item.getby.title;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetItemsResponse {
    private String id;
    private String title;

    private String vendorName;

    private Set<String> tagName;

    private Set<String> multimediaUrl;

    private Boolean isArchived;
}
