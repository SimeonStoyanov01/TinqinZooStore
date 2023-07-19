package com.example.tinqin.zoostore.API.operation.tag.update;

import com.example.tinqin.zoostore.API.base.OperationResponse;
import lombok.*;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TagUpdateResponse implements OperationResponse {

    private UUID tagId;
    private String title;

}
