package com.mmall.dao;

import com.mmall.pojo.OrderItem;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface OrderItemMapper {
    @Delete({
        "delete from mmall_order_item",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into mmall_order_item (id, user_id, ",
        "order_no, product_id, ",
        "product_name, product_image, ",
        "current_unit_price, quantity, ",
        "total_price, create_time, ",
        "update_time)",
        "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{orderNo,jdbcType=BIGINT}, #{productId,jdbcType=INTEGER}, ",
        "#{productName,jdbcType=VARCHAR}, #{productImage,jdbcType=VARCHAR}, ",
        "#{currentUnitPrice,jdbcType=DECIMAL}, #{quantity,jdbcType=INTEGER}, ",
        "#{totalPrice,jdbcType=DECIMAL}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(OrderItem record);

    int insertSelective(OrderItem record);


    @Select("select * from mmall_order_item where id=#{id}")
    OrderItem selectByPrimaryKey(Integer id);

    @Select("select * from mmall_order_item")
    List<OrderItem> selectList();

    int updateByPrimaryKeySelective(OrderItem record);

    @Update({
        "update mmall_order_item",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "order_no = #{orderNo,jdbcType=BIGINT},",
          "product_id = #{productId,jdbcType=INTEGER},",
          "product_name = #{productName,jdbcType=VARCHAR},",
          "product_image = #{productImage,jdbcType=VARCHAR},",
          "current_unit_price = #{currentUnitPrice,jdbcType=DECIMAL},",
          "quantity = #{quantity,jdbcType=INTEGER},",
          "total_price = #{totalPrice,jdbcType=DECIMAL},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OrderItem record);
}