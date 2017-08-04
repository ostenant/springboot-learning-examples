package org.ostenant.springboot.learning.examples.exception;

import lombok.Getter;
import lombok.Setter;

public class NullOrEmptyException extends Exception {

    @Getter
    @Setter
    protected String message;

    public NullOrEmptyException() {
        setMessage("Parameter is null or empty!");
    }

    public NullOrEmptyException(String message) {
        this.message = message;
    }
}
