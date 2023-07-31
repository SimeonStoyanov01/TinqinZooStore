package com.example.tinqin.zoostore.API.operation.tag.getitemsbytag;

import com.example.tinqin.zoostore.API.base.OperationResponse;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TagGetItemsResponse implements OperationResponse {

    Set<GetItemsResponse> allItems = new HashSet<>();
    Integer page;
    Integer size;
    Long totalItems;

}
