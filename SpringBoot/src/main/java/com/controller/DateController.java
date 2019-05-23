package com.controller;


import com.service.IAsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Controller
@RequestMapping("/date")
public class DateController {

    @Autowired
    private IAsyncService asyncService;

    @RequestMapping("/strtodate")
    @ResponseBody
    public String getDate(Date date){
        return date.toString();
    }


    @RequestMapping("/async")
    @ResponseBody
    public String asyncTask() throws InterruptedException, ExecutionException {
        Future<Long> future1 = asyncService.doTask1();
        Future<Long> future2 = asyncService.doTask2();
        Future<Long> future3 = asyncService.doTask3();
        return future1.get()+" "+ future2.get() +" "+ future3.get();
    }
}
