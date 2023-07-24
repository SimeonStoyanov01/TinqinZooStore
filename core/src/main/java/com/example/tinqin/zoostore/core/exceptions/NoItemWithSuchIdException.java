package com.example.tinqin.zoostore.core.exceptions;

public class NoItemWithSuchIdException extends RuntimeException{
    public NoItemWithSuchIdException() {
        super("There is no item with such ID");
    }
}
