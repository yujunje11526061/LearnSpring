package com.controller;


import com.user.Book;
import com.user.Group;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;


@RequestMapping("/book")
@Controller
//@RestController // 如果每个方法返回的都是RESTful的，则可以这么写，后面就不用到处写@ResponseBody了
public class BookController {

    private Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private Book book;

    @RequestMapping("/info")
    @ResponseBody
    public String bookInfo(){
        return book.toString();
    }

    @RequestMapping(value = "json.do",method = RequestMethod.POST,consumes = "application/json",produces ="application/json")
    @ResponseBody
    public Serializable json(@RequestBody Group group) {
        return group;
    }

    @RequestMapping("/err")
    @ResponseBody
    public String testErr(){
        return 5/0+"";
    }
}
