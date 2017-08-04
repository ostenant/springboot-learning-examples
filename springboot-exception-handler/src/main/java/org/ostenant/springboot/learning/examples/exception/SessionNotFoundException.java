package org.ostenant.springboot.learning.examples.exception;


import lombok.Getter;
import lombok.Setter;

public class SessionNotFoundException extends Exception {

    @Getter
    @Setter
    protected String message;

    public SessionNotFoundException() {
        setMessage("Session is not found!");
    }

    public SessionNotFoundException(String message) {
        this.message = message;
    }
}
