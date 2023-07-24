package com.example.tinqin.zoostore.restexport;

import com.example.tinqin.zoostore.API.operation.item.getbyid.ItemGetByIdResponse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.UUID;

@Headers({"Content-Type: application/json"})
public interface ZooStoreRestClient {
    @RequestLine("GET /items/{itemid}")
    ItemGetByIdResponse itemGetById(@Param("itemid") String itemid);

}
