package com.tigana.ErrorHandler.Exceptions;

public class ResourceNotFoundException extends BusinessException {
    public ResourceNotFoundException(String resource) {
        super(resource + " not found");
    }
}