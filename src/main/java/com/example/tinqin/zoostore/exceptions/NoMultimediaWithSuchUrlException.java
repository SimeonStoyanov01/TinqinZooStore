package com.example.tinqin.zoostore.exceptions;

public class NoMultimediaWithSuchUrlException extends RuntimeException{
    public NoMultimediaWithSuchUrlException() {
        super("There is no multimedia with such url");
    }
}