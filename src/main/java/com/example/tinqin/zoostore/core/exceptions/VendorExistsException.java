package com.example.tinqin.zoostore.core.exceptions;

public class VendorExistsException extends RuntimeException{
    public VendorExistsException(){
        super("Vendor alreadyExists");
    }
}
