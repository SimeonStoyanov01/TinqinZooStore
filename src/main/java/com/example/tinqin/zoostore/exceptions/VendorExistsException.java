package com.example.tinqin.zoostore.exceptions;

public class VendorExistsException extends RuntimeException{
    public VendorExistsException(){
        super("Vendor alreadyExists");
    }
}
