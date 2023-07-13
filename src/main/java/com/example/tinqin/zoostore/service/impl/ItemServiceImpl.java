package com.example.tinqin.zoostore.service.impl;

import com.example.tinqin.zoostore.API.request.GetItemByIDRequest;
import com.example.tinqin.zoostore.API.request.ItemCreateRequest;
import com.example.tinqin.zoostore.API.response.GetItemByIDResponse;
import com.example.tinqin.zoostore.API.response.ItemCreateResponse;
import com.example.tinqin.zoostore.data.entity.ItemEntity;
import com.example.tinqin.zoostore.data.repository.ItemRepository;
import com.example.tinqin.zoostore.exceptions.ItemExistsException;
import com.example.tinqin.zoostore.service.ItemService;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public GetItemByIDResponse getItemByID(GetItemByIDRequest getItemByIDRequest) {
        ItemEntity item = itemRepository.findById(getItemByIDRequest.getItemId()).get();
        GetItemByIDResponse itemResponse = GetItemByIDResponse
                .builder()
                .id(item.getId())
                .title(item.getTitle())
                .build();
        return itemResponse;
    }

    @Override
    public ItemCreateResponse createItem(ItemCreateRequest itemCreateRequest) {
        if(itemCreateRequest.getTitle()==null||itemCreateRequest.getTitle().trim().equals("")){
            throw new IllegalArgumentException();
        }
        if(itemRepository.findItemEntityByTitle(itemCreateRequest.getTitle()).isPresent()){
            throw new ItemExistsException();
        }
        ItemEntity item=new ItemEntity();
        item.setTitle(itemCreateRequest.getTitle());
        item.setIsArchived(false);
        itemRepository.save(item);
        ItemCreateResponse createResponse= ItemCreateResponse
                .builder()
                .id(item.getId())
                .title(item.getTitle())
                .isArchived(item.getIsArchived())
                .build();
        return createResponse;
    }
}
