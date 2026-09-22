package com.bestbuds.exception;

public class AgeConfirmationRequiredException
        extends RuntimeException {

    public AgeConfirmationRequiredException(
            String message
    ) {
        super(message);
    }
}