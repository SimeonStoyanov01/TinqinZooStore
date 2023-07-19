package com.example.tinqin.zoostore.API.operation.item.create;

import com.example.tinqin.zoostore.API.base.OperationResponse;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemCreateResponse implements OperationResponse {
    private UUID id;
    private String title;
    private Boolean isArchived;
}
