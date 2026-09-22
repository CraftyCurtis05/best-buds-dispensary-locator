package com.bestbuds.exception;

public class InvalidPasswordException extends RuntimeException {

    public InvalidPasswordException(
            String message
    ) {
        super(message);
    }
}