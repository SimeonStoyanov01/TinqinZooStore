package com.example.tinqin.zoostore.API.operation.tag.create;

import com.example.tinqin.zoostore.API.base.OperationResponse;
import lombok.*;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TagCreateResponse implements OperationResponse {
    private UUID tagID;
    private String title;
    private Boolean is_archived;
}
