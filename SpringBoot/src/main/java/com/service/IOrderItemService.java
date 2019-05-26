package com.service;

import com.mmall.pojo.OrderItem;

import java.util.List;

public interface IOrderItemService {

    public OrderItem getOrderItemByID(Integer id);

    public List<OrderItem> getOrderItemList(Integer pageNum, Integer pageSize);
}
