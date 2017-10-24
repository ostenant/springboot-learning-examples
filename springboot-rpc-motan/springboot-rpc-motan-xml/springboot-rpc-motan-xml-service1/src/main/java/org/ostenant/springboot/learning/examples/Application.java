package org.ostenant.springboot.learning.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = "classpath:motan-server.xml")
public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
//        MotanSwitcherUtil.setSwitcherValue(MotanConstants.REGISTRY_HEARTBEAT_SWITCHER, true);
        System.out.println("Server start ...");
    }
}
