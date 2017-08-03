package org.ostenant.springboot.learning.examples.entities;

import lombok.Value;

/**
 * @Value 就是 @Data 的不可变版本
 */
@Value
public class ValueExample {

    private Integer id;

    private String name;

    private Integer age;
}
