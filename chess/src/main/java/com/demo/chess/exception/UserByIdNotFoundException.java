package com.demo.chess.exception;

public class UserByIdNotFoundException extends RuntimeException{

    public UserByIdNotFoundException() {
    }

    public UserByIdNotFoundException(String message) {
        super(message);
    }

}
