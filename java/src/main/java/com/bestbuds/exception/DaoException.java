package com.bestbuds.exception;

public class DaoException
        extends RuntimeException {

    public DaoException(
            String message,
            Exception cause
    ) {
        super(
                message,
                cause
        );
    }
}