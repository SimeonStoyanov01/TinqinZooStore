package com.example.tinqin.zoostore.service.impl;

import com.example.tinqin.zoostore.API.request.VendorItemAddRequest;
import com.example.tinqin.zoostore.API.response.ItemCreateResponse;
import com.example.tinqin.zoostore.API.response.VendorItemAddResponse;
import com.example.tinqin.zoostore.data.entity.ItemEntity;
import com.example.tinqin.zoostore.data.entity.VendorEntity;
import com.example.tinqin.zoostore.data.repository.ItemRepository;
import com.example.tinqin.zoostore.data.repository.VendorRepository;
import com.example.tinqin.zoostore.exceptions.NoVendorWithSuchIdException;
import com.example.tinqin.zoostore.service.VendorItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
public class VendorItemServiceImpl implements VendorItemService {
    private final ItemRepository itemRepository;
    private final VendorRepository vendorRepository;

    @Autowired
    public VendorItemServiceImpl(ItemRepository itemRepository, VendorRepository vendorRepository) {
        this.itemRepository = itemRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public VendorItemAddResponse addItemToVendor(VendorItemAddRequest vendorItemAddRequest) {
        VendorEntity vendor=this.vendorRepository.findById(vendorItemAddRequest.getVendorId()).orElseThrow(NoVendorWithSuchIdException :: new);
        ItemEntity item=this.itemRepository.findById(vendorItemAddRequest.getItemId()).orElseThrow(null);
        item.setVendor(vendor);
        this.itemRepository.save(item);


        Set<ItemCreateResponse> items = new HashSet<>();
        for(ItemEntity currentItem : vendor.getItems()) {
            ItemCreateResponse currentItemResponse = ItemCreateResponse.builder()
                    .id(currentItem.getId())
                    .title(currentItem.getTitle())
                    .isArchived(currentItem.getIsArchived())
                    .build();
            items.add(currentItemResponse);
        }

        return VendorItemAddResponse
                .builder()
                .vendorId(vendor.getId())
                .title(vendor.getPhoneNumber())
                .phoneNumber(vendor.getName())
                .items(items)
                .build();
    }

    @Override
    public void removeItemFromVendor(UUID vendorId, UUID itemId) {

    }
}
