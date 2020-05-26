package com.example.connect4;

public class ColumnFullException extends RuntimeException {
    public ColumnFullException(String message) {
        super(message);
    }
}
