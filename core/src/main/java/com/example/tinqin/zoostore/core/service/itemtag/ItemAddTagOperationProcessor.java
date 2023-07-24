package com.example.tinqin.zoostore.core.service.itemtag;

import com.example.tinqin.zoostore.API.operation.itemtag.addtag.ItemAddTagOperation;
import com.example.tinqin.zoostore.API.operation.itemtag.addtag.ItemTagAddRequest;
import com.example.tinqin.zoostore.API.operation.itemtag.addtag.ItemTagAddResponse;
import com.example.tinqin.zoostore.API.operation.tag.create.TagCreateResponse;
import com.example.tinqin.zoostore.persistence.entity.ItemEntity;
import com.example.tinqin.zoostore.persistence.entity.TagEntity;
import com.example.tinqin.zoostore.persistence.repository.ItemRepository;
import com.example.tinqin.zoostore.persistence.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ItemAddTagOperationProcessor implements ItemAddTagOperation {
    private final ItemRepository itemRepository;
    private final TagRepository tagRepository;

    public ItemAddTagOperationProcessor(ItemRepository itemRepository, TagRepository tagRepository) {
        this.itemRepository = itemRepository;
        this.tagRepository = tagRepository;
    }


    @Override
    public ItemTagAddResponse process(ItemTagAddRequest operationRequest) {
        ItemEntity item=this.itemRepository.findById(operationRequest.getItemId()).orElseThrow(null);
        TagEntity tag=this.tagRepository.findById(operationRequest.getTagId()).orElseThrow(null);
        //Set<TagEntity> tagEntitySet=new HashSet<>();
        //tagEntitySet.add(tag);
        tag.getItems().add(item);
        item.getTag().add(tag);
        itemRepository.save(item);

        Set<TagCreateResponse>tagCreateResponses=new HashSet<>();
        for (TagEntity currentTag:item.getTag()
        ) {TagCreateResponse currentTagResponse=TagCreateResponse
                .builder()
                .tagID(currentTag.getId())
                .title(currentTag.getTitle())
                .is_archived(currentTag.getIsArchived())
                .build();
            tagCreateResponses.add(currentTagResponse);
        }

        ItemTagAddResponse itemTagAddResponse = ItemTagAddResponse
                .builder()
                .itemId(item.getId())
                .vendorName(item.getVendor().getName())
                .tags(tagCreateResponses)
                .title(item.getTitle())
                .build();


        return itemTagAddResponse;
    }
}
