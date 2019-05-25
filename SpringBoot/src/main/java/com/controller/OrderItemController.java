package com.controller;



import com.mmall.pojo.OrderItem;
import com.service.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderitem")
public class OrderItemController {

    @Autowired
    private IOrderItemService iOrderItemService;

    @RequestMapping("/{id}")
    public OrderItem getOrderItemByID(@PathVariable("id") Integer id){
        return iOrderItemService.getOrderItemByID(id);
    }
}
