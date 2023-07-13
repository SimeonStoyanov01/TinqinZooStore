package com.example.tinqin.zoostore.service;

import com.example.tinqin.zoostore.API.request.GetItemByIDRequest;
import com.example.tinqin.zoostore.API.request.ItemCreateRequest;
import com.example.tinqin.zoostore.API.response.GetItemByIDResponse;
import com.example.tinqin.zoostore.API.response.ItemCreateResponse;

public interface ItemService {
     GetItemByIDResponse getItemByID(GetItemByIDRequest getItemByIDRequest);

     ItemCreateResponse createItem(ItemCreateRequest itemCreateRequest);


}
