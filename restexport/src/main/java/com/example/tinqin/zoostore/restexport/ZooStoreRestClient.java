package com.example.tinqin.zoostore.restexport;

import com.example.tinqin.zoostore.API.operation.item.getbyid.ItemGetByIdResponse;
import com.example.tinqin.zoostore.API.operation.tag.getitemsbytag.TagGetItemsResponse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers({"Content-Type: application/json"})
public interface ZooStoreRestClient {
    @RequestLine("GET /items/{itemid}")
    ItemGetByIdResponse itemGetById(@Param("itemid") String itemid);

    @RequestLine("GET /tag/tagName?tagName={tagName}&page={page}&size={size}")
    TagGetItemsResponse tagGetItem(@Param("tagName") String tagName,@Param("page")Integer page,@Param("size")Integer size);

}
