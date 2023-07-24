package com.example.tinqin.zoostore.core.service.vendoritem;

import com.example.tinqin.zoostore.API.operation.item.create.ItemCreateResponse;
import com.example.tinqin.zoostore.API.operation.vendoritem.add.VendorAddItemOperation;
import com.example.tinqin.zoostore.API.operation.vendoritem.add.VendorItemAddRequest;
import com.example.tinqin.zoostore.API.operation.vendoritem.add.VendorItemAddResponse;
import com.example.tinqin.zoostore.core.exceptions.NoVendorWithSuchIdException;
import com.example.tinqin.zoostore.persistence.entity.ItemEntity;
import com.example.tinqin.zoostore.persistence.entity.VendorEntity;
import com.example.tinqin.zoostore.persistence.repository.ItemRepository;
import com.example.tinqin.zoostore.persistence.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class VendorAddItemOperationProcessor implements VendorAddItemOperation {
    private final ItemRepository itemRepository;
    private final VendorRepository vendorRepository;

    @Autowired
    public VendorAddItemOperationProcessor(ItemRepository itemRepository, VendorRepository vendorRepository) {
        this.itemRepository = itemRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public VendorItemAddResponse process(VendorItemAddRequest operationRequest) {
        VendorEntity vendor=this.vendorRepository.findById(operationRequest.getVendorId()).orElseThrow(NoVendorWithSuchIdException :: new);
        ItemEntity item=this.itemRepository.findById(operationRequest.getItemId()).orElseThrow(null);
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
}
