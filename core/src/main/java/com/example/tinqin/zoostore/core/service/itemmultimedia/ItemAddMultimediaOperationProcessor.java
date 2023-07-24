package com.example.tinqin.zoostore.core.service.itemmultimedia;

import com.example.tinqin.zoostore.API.operation.itemmultimedia.add.ItemAddMultimediaOperation;
import com.example.tinqin.zoostore.API.operation.itemmultimedia.add.ItemMultimediaAddRequest;
import com.example.tinqin.zoostore.API.operation.itemmultimedia.add.ItemMultimediaAddResponse;
import com.example.tinqin.zoostore.API.operation.multimedia.create.MultimediaCreateResponse;
import com.example.tinqin.zoostore.persistence.entity.ItemEntity;
import com.example.tinqin.zoostore.persistence.entity.MultimediaEntity;
import com.example.tinqin.zoostore.persistence.repository.ItemRepository;
import com.example.tinqin.zoostore.persistence.repository.MultimediaRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class ItemAddMultimediaOperationProcessor implements ItemAddMultimediaOperation {
    private final ItemRepository itemRepository;
    private final MultimediaRepository multimediaRepository;

    public ItemAddMultimediaOperationProcessor(ItemRepository itemRepository, MultimediaRepository multimediaRepository) {
        this.itemRepository = itemRepository;
        this.multimediaRepository = multimediaRepository;
    }

    @Override
    public ItemMultimediaAddResponse process(ItemMultimediaAddRequest operationRequest) {
        ItemEntity item=this.itemRepository.findById(operationRequest.getItemId()).orElseThrow(null);
        MultimediaEntity multimedia=this.multimediaRepository.findById(operationRequest.getMultimediaId()).orElseThrow(null);
        item.getMultimedia().add(multimedia);
        itemRepository.save(item);

        Set<MultimediaCreateResponse> multimediaCreateResponses=new HashSet<>();
        for (MultimediaEntity currentMultimedia:item.getMultimedia()
        ) {MultimediaCreateResponse multimediaCreateResponse=MultimediaCreateResponse
                .builder()
                .multimediaID(currentMultimedia.getId())
                .is_archived(currentMultimedia.getIsArchived())
                .url(currentMultimedia.getUrl())
                .build();
            multimediaCreateResponses.add(multimediaCreateResponse);
        }

        return ItemMultimediaAddResponse
                .builder()
                .title(item.getTitle())
                .vendorName(item.getVendor().getName())
                .multimedia(multimediaCreateResponses)
                .itemId(item.getId())
                .build();
    }
}
