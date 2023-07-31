package com.example.tinqin.zoostore.core.exceptions;

public class NoItemWithSuchTagException extends RuntimeException{
    public NoItemWithSuchTagException() {
        super("There is no item with such tagId");
    }
}