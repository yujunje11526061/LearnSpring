package com.controller;


import com.user.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


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
}
