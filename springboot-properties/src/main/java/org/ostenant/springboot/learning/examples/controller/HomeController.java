package org.ostenant.springboot.learning.examples.controller;

import org.ostenant.springboot.learning.examples.HomeProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Madison on 2017/6/27.
 */
@RestController
public class HomeController {

    @Autowired
    private HomeProperties homeProperties;

    @GetMapping
    public HomeProperties home() {
        return homeProperties;
    }
}
