package com.digitalfactory.irrigationsystem.exceptions;

public class ResourceAlreadyExistException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    public ResourceAlreadyExistException(String message) {
        super(message);
    }
    
    public ResourceAlreadyExistException(String entity, Object value) {
        super(entity + " already exit for user with id : " + value);
    }
    
}
