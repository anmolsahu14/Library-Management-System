package com.example.LibraryManagementSystem.Exceptions;

public class BookNotAvailableException extends RuntimeException {

    public BookNotAvailableException(String message) {
        super(message);
    }
}
