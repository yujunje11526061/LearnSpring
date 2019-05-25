package com.service.serviceImpl;

import com.mmall.dao.OrderItemMapper;
import com.mmall.pojo.OrderItem;
import com.service.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("iOrderItemService")
public class OrderItemServiceImpl implements IOrderItemService {

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public OrderItem getOrderItemByID(Integer id) {


        return orderItemMapper.selectByPrimaryKey(id);
    }
}
