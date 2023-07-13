package com.example.tinqin.zoostore.exceptions;

public class MultimediaExistsException extends RuntimeException{
    public MultimediaExistsException() {
        super("Multimedia already exists");
    }
}
