package com.demo.chess.exception;

public class LobbyByIdNotFoundException extends RuntimeException{

    public LobbyByIdNotFoundException() {
    }

    public LobbyByIdNotFoundException(String message) {
        super(message);
    }

}
