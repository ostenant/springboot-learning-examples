package org.ostenant.springboot.learning.examples.exception;

import lombok.Getter;
import lombok.Setter;

public class IllegalPropException extends Exception {

    @Getter
    @Setter
    protected String message;

    public IllegalPropException() {
        setMessage("Prop is illegal!");
    }

    public IllegalPropException(String message) {
        this.message = message;
        setMessage(String.format("Prop: %s is illegal!", message));
    }
}
