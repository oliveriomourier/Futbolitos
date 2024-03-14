package com.example.futbolitos2.exception;

public class UserAlreadyCreatedException extends RuntimeException{
    public UserAlreadyCreatedException(String message){
        super(message);
    }
}
