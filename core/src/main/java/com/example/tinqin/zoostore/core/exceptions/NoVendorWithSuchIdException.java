package com.example.tinqin.zoostore.core.exceptions;

public class NoVendorWithSuchIdException extends RuntimeException{
    public NoVendorWithSuchIdException(){
        super("There is no vendor with such Id");
    }
}
