package com.example.tinqin.zoostore.API.operation.item.updatetodo;

import com.example.tinqin.zoostore.API.base.OperationResponse;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemUpdateResponse implements OperationResponse {
    private UUID id;
    private String title;
}
