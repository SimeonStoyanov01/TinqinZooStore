package com.example.tinqin.zoostore.core.service.item;

import com.example.tinqin.zoostore.API.operation.item.getall.ItemGetAllByIdRequest;
import com.example.tinqin.zoostore.API.operation.item.getall.ItemGetAllByIdResponse;
import com.example.tinqin.zoostore.API.operation.item.getall.ItemGetAllOperation;
import com.example.tinqin.zoostore.API.operation.item.getall.ItemResponse;
import com.example.tinqin.zoostore.persistence.entity.ItemEntity;
import com.example.tinqin.zoostore.persistence.entity.TagEntity;
import com.example.tinqin.zoostore.persistence.repository.ItemRepository;
import com.example.tinqin.zoostore.persistence.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class GetAllOperationProcessor implements ItemGetAllOperation {
    private final ItemRepository itemRepository;
    private final TagRepository tagRepository;


    @Override
    public ItemGetAllByIdResponse process(ItemGetAllByIdRequest operationRequest) {
        List<ItemEntity> allItems=itemRepository.findAll();

        ItemGetAllByIdResponse allByIdResponses=new ItemGetAllByIdResponse();

        Set<String> multimediaSet=new HashSet<>();


        for (ItemEntity currentItem:allItems) {
//            currentItem.getTag().forEach(tagEntity -> tagEntity.getTitle());
//            currentItem.getMultimedia().forEach(multimediaEntity -> multimediaEntity.getUrl());
            Set<String> tagSet=new HashSet<>();
            Set<TagEntity>tags= currentItem.getTag();
//            Set<TagEntity>tags=tagRepository.getTagEntitiesByItems(currentItem.getId());
            String vendorName = currentItem.getVendor() != null ? currentItem.getVendor().getName() : null;
            //tagSet.clear();
            for (TagEntity tag:tags) {


                tagSet.add(tag.getTitle());
            }
            ItemResponse itemResponse = ItemResponse
                    .builder()
                    .tagName(tagSet)
                    .title(currentItem.getTitle())
                    .id(currentItem.getId())
                    .vendorName(vendorName)
                    .isArchived(currentItem.getIsArchived())
                    .build();
            allByIdResponses.getItemResponseList().add(itemResponse);

        }
//        ItemGetAllByIdResponse itemGetAllByIdResponse=ItemGetAllByIdResponse.builder()
//                .itemResponseList(allByIdResponses.getItemResponseList())
//                .build();
//                .tagName(currentItem.getTag())
//                .multimediaUrl(currentItem.getMultimedia())
//                .title(currentItem.getTitle())
//                .isArchived(currentItem.getIsArchived())
//                .build();
        return allByIdResponses;
    }
}
