package org.ostenant.springboot.learning.examples.entities;

import lombok.extern.java.Log;

import java.util.logging.Level;

@Log(topic = "Lombok")
public class LogExample {

    public static void main(String[] args) {
        log.log(Level.INFO, "Something's wrong here");
    }
}

