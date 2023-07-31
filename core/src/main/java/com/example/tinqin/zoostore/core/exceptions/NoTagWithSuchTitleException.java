package com.example.tinqin.zoostore.core.exceptions;

public class NoTagWithSuchTitleException extends RuntimeException{
    public NoTagWithSuchTitleException() {
        super("There is no tag with such title");
    }
}
