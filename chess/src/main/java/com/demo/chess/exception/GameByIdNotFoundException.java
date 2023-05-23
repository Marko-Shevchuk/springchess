package com.demo.chess.exception;

public class GameByIdNotFoundException extends RuntimeException{

    public GameByIdNotFoundException() {
    }

    public GameByIdNotFoundException(String message) {
        super(message);
    }

}
