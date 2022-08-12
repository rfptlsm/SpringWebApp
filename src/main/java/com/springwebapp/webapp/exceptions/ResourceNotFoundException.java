package com.springwebapp.webapp.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String messsage){
        super(messsage);
    }
}