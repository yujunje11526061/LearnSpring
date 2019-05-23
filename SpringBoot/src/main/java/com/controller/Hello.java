package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller(value = "com/controller")
@RequestMapping("/home")
public class Hello {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam(defaultValue = "World") String name){
        return "Hello~~~ "+name;
    }
}
