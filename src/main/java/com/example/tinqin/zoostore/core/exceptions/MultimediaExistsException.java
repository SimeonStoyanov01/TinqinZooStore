package com.example.tinqin.zoostore.core.exceptions;

public class MultimediaExistsException extends RuntimeException{
    public MultimediaExistsException() {
        super("Multimedia already exists");
    }
}
