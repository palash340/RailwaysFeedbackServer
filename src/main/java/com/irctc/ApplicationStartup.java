package com.irctc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

@Controller
@EnableAutoConfiguration
@ComponentScan(basePackages  = {"com.irctc"})
public class ApplicationStartup {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationStartup.class, args);
    }
}
