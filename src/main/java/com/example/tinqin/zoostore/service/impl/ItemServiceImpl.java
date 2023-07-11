package com.example.tinqin.zoostore.service.impl;

import com.example.tinqin.zoostore.API.request.GetItemByIDRequest;
import com.example.tinqin.zoostore.API.response.GetItemByIDResponse;
import com.example.tinqin.zoostore.data.entity.ItemEntity;
import com.example.tinqin.zoostore.data.repository.ItemRepository;
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
}
