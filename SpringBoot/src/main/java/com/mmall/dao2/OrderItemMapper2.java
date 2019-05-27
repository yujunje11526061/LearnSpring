package com.mmall.dao2;


import com.mmall.pojo.OrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderItemMapper2 {

    @Select("select * from mmall_order_item where id=#{id}")
    OrderItem selectByPrimaryKey(Integer id);

    @Select("select * from mmall_order_item")
    List<OrderItem> selectList();
}
