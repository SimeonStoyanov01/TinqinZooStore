package com.example.tinqin.zoostore.API.operation.item.getby.title;

import com.example.tinqin.zoostore.API.base.OperationResponse;
import lombok.*;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemGetByTitleResponse implements OperationResponse {
    List<GetItemsResponse> allItems = new ArrayList<>();
    Integer page;
    Integer size;
    Long totalItems;
}
