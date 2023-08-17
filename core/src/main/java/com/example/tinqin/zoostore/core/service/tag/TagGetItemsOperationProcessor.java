package com.example.tinqin.zoostore.core.service.tag;

import com.example.tinqin.zoostore.API.operation.tag.getitemsbytag.GetItemsResponse;
import com.example.tinqin.zoostore.API.operation.tag.getitemsbytag.TagGetItemsOperation;
import com.example.tinqin.zoostore.API.operation.tag.getitemsbytag.TagGetItemsRequest;
import com.example.tinqin.zoostore.API.operation.tag.getitemsbytag.TagGetItemsResponse;
import com.example.tinqin.zoostore.core.exceptions.NoItemWithSuchTagException;
import com.example.tinqin.zoostore.core.exceptions.NoTagWithSuchTitleException;
import com.example.tinqin.zoostore.persistence.entity.ItemEntity;
import com.example.tinqin.zoostore.persistence.entity.MultimediaEntity;
import com.example.tinqin.zoostore.persistence.entity.TagEntity;
import com.example.tinqin.zoostore.persistence.repository.ItemRepository;
import com.example.tinqin.zoostore.persistence.repository.TagRepository;
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
public class TagGetItemsOperationProcessor implements TagGetItemsOperation {
    private final TagRepository tagRepository;
    private final ItemRepository itemRepository;

    public TagGetItemsOperationProcessor(TagRepository tagRepository, ItemRepository itemRepository) {
        this.tagRepository = tagRepository;
        this.itemRepository = itemRepository;
    }


    @Override
    public TagGetItemsResponse process(TagGetItemsRequest operationRequest) {
        TagEntity tag = tagRepository.findTagEntityByTitle(operationRequest
                .getTagTitle()).orElseThrow(NoTagWithSuchTitleException::new);

        Pageable pageable = PageRequest.of(operationRequest.getPage(), operationRequest.getSize());

        Page<ItemEntity> itemEntityPage = itemRepository.findItemEntitiesByTagId(tag.getId(), pageable);

        List<ItemEntity> items = itemEntityPage.getContent();

        Set<GetItemsResponse> itemsResponseSet = new HashSet<>();

        //TagGetItemsResponse tagGetItemsResponse=new TagGetItemsResponse();
        for (ItemEntity currentItem : items) {
            tag.getItems().add(currentItem);
            Set<String> tagNames = new HashSet<>();
            Set<TagEntity> tagEntitySet = currentItem.getTag();

            for (TagEntity currentTag : tagEntitySet) {
                tagNames.add(currentTag.getTitle());
            }

            Set<String> multimediaUrlSet;

            Set<MultimediaEntity> multimediaEntitySet = currentItem.getMultimedia();

            multimediaUrlSet = multimediaEntitySet.stream().map(MultimediaEntity::getUrl).collect(Collectors.toSet());

            GetItemsResponse getItemsResponse =
                    GetItemsResponse
                            .builder()
                            .tagName(tagNames)
                            .id(String.valueOf(currentItem.getId()))
                            .vendorName(currentItem.getVendor().getName())
                            .title(currentItem.getTitle())
                            .multimediaUrl(multimediaUrlSet)
                            .build();

            itemsResponseSet.add(getItemsResponse);
        }

        return TagGetItemsResponse
                .builder()
                .allItems(itemsResponseSet)
                .totalItems(itemEntityPage.getTotalElements())
                .page(itemEntityPage.getNumber())
                .size(itemEntityPage.getSize())
                .build();
    }
}
