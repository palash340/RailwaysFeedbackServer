package com.irctc;

import com.irctc.beans.TwitterProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

@Controller
@EnableAutoConfiguration
@ComponentScan(basePackages  = {"com.irctc"})
public class ApplicationStartup {

    @Autowired
    TwitterProperties twitterProperties;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationStartup.class, args);
    }
}
