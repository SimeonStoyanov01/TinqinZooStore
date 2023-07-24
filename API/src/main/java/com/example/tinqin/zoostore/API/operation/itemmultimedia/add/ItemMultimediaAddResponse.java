package com.example.tinqin.zoostore.API.operation.itemmultimedia.add;

import com.example.tinqin.zoostore.API.base.OperationResponse;
import com.example.tinqin.zoostore.API.operation.multimedia.create.MultimediaCreateResponse;
import lombok.*;

import java.util.Set;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemMultimediaAddResponse implements OperationResponse {
    private UUID itemId;
    private String title;

    private String vendorName;

    private Set<MultimediaCreateResponse> multimedia;
}
