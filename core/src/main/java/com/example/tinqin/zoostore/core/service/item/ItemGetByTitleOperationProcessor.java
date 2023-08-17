package com.example.tinqin.zoostore.core.service.item;

import com.example.tinqin.zoostore.API.operation.item.getby.title.GetItemsResponse;
import com.example.tinqin.zoostore.API.operation.item.getby.title.ItemGetByTitleOperation;
import com.example.tinqin.zoostore.API.operation.item.getby.title.ItemGetByTitleRequest;
import com.example.tinqin.zoostore.API.operation.item.getby.title.ItemGetByTitleResponse;
import com.example.tinqin.zoostore.persistence.entity.ItemEntity;
import com.example.tinqin.zoostore.persistence.entity.MultimediaEntity;
import com.example.tinqin.zoostore.persistence.entity.TagEntity;
import com.example.tinqin.zoostore.persistence.repository.ItemRepository;
import com.example.tinqin.zoostore.persistence.repository.MultimediaRepository;
import com.example.tinqin.zoostore.persistence.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ItemGetByTitleOperationProcessor implements ItemGetByTitleOperation {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemGetByTitleOperationProcessor(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public ItemGetByTitleResponse process(ItemGetByTitleRequest operationRequest) {

        Pageable pageable = PageRequest.of(operationRequest.getPage(), operationRequest.getSize());

        Page<ItemEntity> itemPage = itemRepository.findAllByPartialTitle(operationRequest.getItemTitle(), pageable);

        List<ItemEntity> itemSet = itemPage.getContent();

        List<GetItemsResponse> itemEntityList = new ArrayList<>();

        itemSet.forEach(i -> {

            Set<MultimediaEntity> multimediaEntities = i.getMultimedia();
            Set<TagEntity> tagEntities = i.getTag();

            Set<String> urls = multimediaEntities.stream().map(MultimediaEntity::getUrl).collect(Collectors.toSet());
            Set<String> tags = tagEntities.stream().map(TagEntity::getTitle).collect(Collectors.toSet());

            itemEntityList.add(GetItemsResponse
                    .builder()
                    .id(i.getId().toString())
                    .title(i.getTitle())
                    .vendorName(i.getVendor().getName())
                    .isArchived(i.getIsArchived())
                    .multimediaUrl(urls)
                    .tagName(tags)
                    .build());
        });

        return ItemGetByTitleResponse
                .builder()
                .allItems(itemEntityList)
                .size(itemPage.getSize())
                .page(itemPage.getNumber())
                .totalItems(itemPage.getTotalElements())
                .build();
    }
}
