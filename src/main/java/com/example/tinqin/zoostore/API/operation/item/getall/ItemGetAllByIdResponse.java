package com.example.tinqin.zoostore.API.operation.item.getall;

import com.example.tinqin.zoostore.API.base.OperationResponse;
import com.example.tinqin.zoostore.persistence.entity.MultimediaEntity;
import com.example.tinqin.zoostore.persistence.entity.TagEntity;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemGetAllByIdResponse implements OperationResponse {


    private List<ItemResponse> itemResponseList = new ArrayList<>();
}
