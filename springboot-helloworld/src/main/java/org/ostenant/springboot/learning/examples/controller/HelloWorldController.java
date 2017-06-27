package org.ostenant.springboot.learning.examples.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Madison on 2017/6/22.
 */
@RestController
public class HelloWorldController {

    @RequestMapping
    public String index() {
        return "Hello, Madison!";
    }
}
