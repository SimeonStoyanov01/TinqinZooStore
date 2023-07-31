package com.example.tinqin.zoostore.API.operation.tag.getitemsbytag;

import com.example.tinqin.zoostore.API.base.OperationRequest;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TagGetItemsRequest implements OperationRequest {

    private String tagTitle;
    private Integer page;
    private Integer size;
}
