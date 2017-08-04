package org.ostenant.springboot.learning.examples.entities;

import lombok.extern.apachecommons.CommonsLog;

@CommonsLog(topic = "Lombok")
public class CommonsLogExample {

    public static void main(String[] args) {
        log.error("Something's wrong here");
    }
}

