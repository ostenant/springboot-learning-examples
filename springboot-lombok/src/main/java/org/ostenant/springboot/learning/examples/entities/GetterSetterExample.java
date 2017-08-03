package org.ostenant.springboot.learning.examples.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class GetterSetterExample {

    @Getter
    @Setter
    private Integer age = 10;

    @Setter
    @Getter(AccessLevel.PROTECTED)
    private String name;

    @Override
    public String toString() {
        return String.format("(name: %s) (age: %d)", name, age);
    }
}
