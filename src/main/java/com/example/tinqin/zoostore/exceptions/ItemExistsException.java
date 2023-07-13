package com.example.tinqin.zoostore.exceptions;

public class ItemExistsException extends RuntimeException{
    public ItemExistsException(){
        super("This item already exists");
    }
}
