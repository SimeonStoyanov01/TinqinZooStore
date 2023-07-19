package com.example.tinqin.zoostore.core.exceptions;

public class TagExistsException extends RuntimeException {
    public TagExistsException(){
        super("Tag already exists");
    }
}
