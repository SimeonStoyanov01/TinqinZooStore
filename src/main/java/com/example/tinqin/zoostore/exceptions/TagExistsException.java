package com.example.tinqin.zoostore.exceptions;

public class TagExistsException extends RuntimeException {
    public TagExistsException(){
        super("Tag already exists");
    }
}
