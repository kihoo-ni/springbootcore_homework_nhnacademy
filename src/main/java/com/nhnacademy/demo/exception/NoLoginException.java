package com.nhnacademy.demo.exception;

public class NoLoginException extends RuntimeException {
    public NoLoginException(String message) {
        super(message);
    }
}
