package com.irctc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class GetFeedbackController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "MyWorld";
    }

    @PostConstruct
    public void printMe(){
        System.err.println("I am calling you");
    }
}
