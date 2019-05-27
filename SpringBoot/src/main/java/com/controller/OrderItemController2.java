package com.controller;


import com.mmall.pojo.OrderItem;
import com.service.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orderitem2")
public class OrderItemController2 {

    @Autowired
    @Qualifier(value = "iOrderItemServiceImpl2") // 指定注入的到底是哪个
    private IOrderItemService iOrderItemService2;

    @RequestMapping("/{id}")
    public OrderItem getOrderItemByID(@PathVariable("id") Integer id){
        return iOrderItemService2.getOrderItemByID(id);
    }

    @RequestMapping("/{pageNum}/{pageSize}")
    public List<OrderItem> getOrderItemByID(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize){
        return iOrderItemService2.getOrderItemList(pageNum,pageSize);
    }
}
