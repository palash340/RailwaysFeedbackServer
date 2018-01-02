package com.irctc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@Controller
public class GetFeedbackController {

    @RequestMapping("/home")
    @ResponseBody
    String home() {
        return "MyWorld";
    }

    @RequestMapping("/home/@id")
    @ResponseBody
    String home(@PathVariable int id) {
        System.out.println(id);
        return "MyWorld";
    }
}
