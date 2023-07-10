package com.example.tinqin.zoostore.service.impl;

import com.example.tinqin.zoostore.repository.ItemRepository;
import com.example.tinqin.zoostore.service.ItemService;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public String getItemByID() {
        String s ="new string";
        return s;
    }
}
