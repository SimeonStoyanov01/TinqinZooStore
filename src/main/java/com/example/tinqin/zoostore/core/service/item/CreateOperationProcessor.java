package com.example.tinqin.zoostore.core.service.item;

import com.example.tinqin.zoostore.API.operation.item.create.ItemCreateRequest;
import com.example.tinqin.zoostore.API.operation.item.create.ItemCreateResponse;
import com.example.tinqin.zoostore.persistence.entity.ItemEntity;
import com.example.tinqin.zoostore.persistence.repository.ItemRepository;
import com.example.tinqin.zoostore.core.exceptions.ItemExistsException;
import com.example.tinqin.zoostore.API.operation.item.create.ItemCreateOperation;
import org.springframework.stereotype.Service;

@Service
public class CreateOperationProcessor implements ItemCreateOperation {

    private final ItemRepository itemRepository;

    public CreateOperationProcessor(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

//    @Override
//    public GetItemByIDResponse getItemByID(GetItemByIDRequest getItemByIDRequest) {
//        ItemEntity item = itemRepository.findById(getItemByIDRequest.getItemId()).get();
//        GetItemByIDResponse itemResponse = GetItemByIDResponse
//                .builder()
//                .id(item.getId())
//                .title(item.getTitle())
//                .build();
//        return itemResponse;
//    }



//    @Override
//    public List<ItemGetAllByIdResponse> g List<ItemEntity> allItems=this.itemRepository.findAll();
////        List<ItemGetAllByIdResponse> allByIdResponses=new ArrayList<>();
////        for (ItemEntity currentItem:allItems
////             ) {ItemGetAllByIdResponse itemGetAllByIdResponse=ItemGetAllByIdResponse
////                .builder()
////                .vendorName(currentItem.getVendor().getName())
////                .tagName(currentItem.getTag())
////                .multimediaUrl(currentItem.getMultimedia())
////                .title(currentItem.getTitle())
////                .isArchived(currentItem.getIsArchived())
////                .build();
////            allByIdResponses.add(itemGetAllByIdResponse);
////
////        }
////        return allByIdResponses;etALlItems() {
//
//    }

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
        ItemCreateResponse createResponse= ItemCreateResponse
                .builder()
                .id(item.getId())
                .title(item.getTitle())
                .isArchived(item.getIsArchived())
                .build();
        return createResponse;
    }
}
