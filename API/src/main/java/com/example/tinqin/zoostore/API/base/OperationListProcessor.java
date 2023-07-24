package com.example.tinqin.zoostore.API.base;

import java.util.List;

public interface OperationListProcessor <R extends OperationResponse,T extends OperationRequest>{
    List<R> process(T operationRequest);
}
