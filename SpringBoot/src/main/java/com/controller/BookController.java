package com.controller;


import com.user.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@RequestMapping("/book")
@Controller
public class BookController {

    @Autowired
    private Book book;

    @RequestMapping("/info")
    @ResponseBody
    public String bookInfo(){
        return book.toString();
    }
}
