package com.example.tinqin.zoostore.API.operation.item.getall;

import com.example.tinqin.zoostore.API.base.OperationResponse;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemGetAllByIdResponse implements OperationResponse {


    private List<ItemResponse> itemResponseList = new ArrayList<>();
}
