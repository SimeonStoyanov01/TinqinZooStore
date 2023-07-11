package com.example.tinqin.zoostore.service;

import com.example.tinqin.zoostore.API.request.GetItemByIDRequest;
import com.example.tinqin.zoostore.API.response.GetItemByIDResponse;

public interface ItemService {
     GetItemByIDResponse getItemByID(GetItemByIDRequest getItemByIDRequest);



}
