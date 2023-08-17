package com.example.tinqin.zoostore.API.operation.item.getby.title;

import com.example.tinqin.zoostore.API.base.OperationRequest;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemGetByTitleRequest implements OperationRequest {
    private String itemTitle;
    private Integer page;
    private Integer size;}
