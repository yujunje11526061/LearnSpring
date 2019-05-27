package com.mmall.dao;

import com.mmall.pojo.Order;
import org.apache.ibatis.annotations.*;


@Mapper
public interface OrderMapper {
    @Delete({
        "delete from mmall_order",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into mmall_order (id, order_no, ",
        "user_id, shipping_id, ",
        "payment, payment_type, ",
        "postage, status, ",
        "payment_time, send_time, ",
        "end_time, close_time, ",
        "create_time, update_time)",
        "values (#{id,jdbcType=INTEGER}, #{orderNo,jdbcType=BIGINT}, ",
        "#{userId,jdbcType=INTEGER}, #{shippingId,jdbcType=INTEGER}, ",
        "#{payment,jdbcType=DECIMAL}, #{paymentType,jdbcType=INTEGER}, ",
        "#{postage,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{paymentTime,jdbcType=TIMESTAMP}, #{sendTime,jdbcType=TIMESTAMP}, ",
        "#{endTime,jdbcType=TIMESTAMP}, #{closeTime,jdbcType=TIMESTAMP}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(Order record);

    int insertSelective(Order record);

    @Select({
        "select",
        "id, order_no, user_id, shipping_id, payment, payment_type, postage, status, ",
        "payment_time, send_time, end_time, close_time, create_time, update_time",
        "from mmall_order",
        "where id = #{id,jdbcType=INTEGER}"
    })
    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    @Update({
        "update mmall_order",
        "set order_no = #{orderNo,jdbcType=BIGINT},",
          "user_id = #{userId,jdbcType=INTEGER},",
          "shipping_id = #{shippingId,jdbcType=INTEGER},",
          "payment = #{payment,jdbcType=DECIMAL},",
          "payment_type = #{paymentType,jdbcType=INTEGER},",
          "postage = #{postage,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "payment_time = #{paymentTime,jdbcType=TIMESTAMP},",
          "send_time = #{sendTime,jdbcType=TIMESTAMP},",
          "end_time = #{endTime,jdbcType=TIMESTAMP},",
          "close_time = #{closeTime,jdbcType=TIMESTAMP},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Order record);
}