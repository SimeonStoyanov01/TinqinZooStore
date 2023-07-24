package com.example.tinqin.zoostore.core.service.item;

import com.example.tinqin.zoostore.API.operation.item.create.ItemCreateOperation;
import com.example.tinqin.zoostore.API.operation.item.create.ItemCreateRequest;
import com.example.tinqin.zoostore.API.operation.item.create.ItemCreateResponse;
import com.example.tinqin.zoostore.core.exceptions.ItemExistsException;
import com.example.tinqin.zoostore.persistence.entity.ItemEntity;
import com.example.tinqin.zoostore.persistence.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateOperationProcessor implements ItemCreateOperation {

    private final ItemRepository itemRepository;

    public CreateOperationProcessor(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    @Override
    public ItemCreateResponse process(ItemCreateRequest operationRequest) {
        if(operationRequest.getTitle()==null||operationRequest.getTitle().trim().equals("")){
            throw new IllegalArgumentException();
        }
        if(itemRepository.findItemEntityByTitle(operationRequest.getTitle()).isPresent()){
            throw new ItemExistsException();
        }
        ItemEntity item=new ItemEntity();
        item.setTitle(operationRequest.getTitle());
        item.setIsArchived(false);
        itemRepository.save(item);
        return ItemCreateResponse
                .builder()
                .id(item.getId())
                .title(item.getTitle())
                .isArchived(item.getIsArchived())
                .build();
    }
}
