package com.example.tinqin.zoostore.API.base;

public interface OperationProcessor<R extends OperationResponse,T extends OperationRequest>{
    R process(T operationRequest);
}
