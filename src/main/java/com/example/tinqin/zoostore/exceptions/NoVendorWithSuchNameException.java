package com.example.tinqin.zoostore.exceptions;

public class NoVendorWithSuchNameException extends RuntimeException {
    public NoVendorWithSuchNameException(){
        super("There is no vendor with such name");
    }
}

