package org.ostenant.springboot.learning.examples.entities;

import lombok.Builder;
import lombok.Singular;

import java.util.List;

/**
 *
 */
@Builder
public class BuilderExample {

    private Integer id;

    private String name;

    @Singular
    private List<String> hobbies;
}
