package com.example.tinqin.zoostore.exceptions;

public class NoTagWithSuchIdException extends RuntimeException{
    public NoTagWithSuchIdException() {
        super("There is no tag with such ID");
    }
}
