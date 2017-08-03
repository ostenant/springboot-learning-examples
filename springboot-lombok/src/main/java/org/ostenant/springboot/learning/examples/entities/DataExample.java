package org.ostenant.springboot.learning.examples.entities;

import lombok.Data;

/**
 * @Data 注解相当于以下注解的集合
 * <p>
 * @ToString
 * @EqualsAndHashCode
 * @Getter (所有字段)
 * @Setter (所有非final字段)
 * @RequiredArgsConstructor
 */
@Data
public class DataExample {

    private Integer id;

    private String name;

    private Integer age;
}
