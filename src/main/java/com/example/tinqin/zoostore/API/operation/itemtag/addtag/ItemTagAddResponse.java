package com.example.tinqin.zoostore.API.operation.itemtag.addtag;

import com.example.tinqin.zoostore.API.base.OperationResponse;
import com.example.tinqin.zoostore.API.operation.tag.create.TagCreateResponse;
import lombok.*;

import java.util.Set;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemTagAddResponse implements OperationResponse {

    private UUID itemId;
    private String title;

    private String vendorName;

    private Set<TagCreateResponse> tags;
}
