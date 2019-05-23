package com.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/date")
public class DateController {

    @RequestMapping("/strtodate")
    @ResponseBody
    public String getDate(Date date){
        return date.toString();
    }
}
