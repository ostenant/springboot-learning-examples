package org.ostenant.springboot.learning.examples;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Madison
 * Scan master.mapper interface
 */
@SpringBootApplication
@MapperScan("org.ostenant.springboot.learning.examples.master.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
