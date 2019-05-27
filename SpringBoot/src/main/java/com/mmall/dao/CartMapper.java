package com.mmall.dao;

import com.mmall.pojo.Cart;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CartMapper {
    @Delete({
            "delete from mmall_cart",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into mmall_cart (id, user_id, ",
            "product_id, quantity, ",
            "checked, create_time, ",
            "update_time)",
            "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
            "#{productId,jdbcType=INTEGER}, #{quantity,jdbcType=INTEGER}, ",
            "#{checked,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
            "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(Cart record);

    int insertSelective(Cart record);

    @Select({
            "select",
            "id, user_id, product_id, quantity, checked, create_time, update_time",
            "from mmall_cart",
            "where id = #{id,jdbcType=INTEGER}"
    })
    Cart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cart record);

    @Update({
            "update mmall_cart",
            "set user_id = #{userId,jdbcType=INTEGER},",
            "product_id = #{productId,jdbcType=INTEGER},",
            "quantity = #{quantity,jdbcType=INTEGER},",
            "checked = #{checked,jdbcType=INTEGER},",
            "create_time = #{createTime,jdbcType=TIMESTAMP},",
            "update_time = #{updateTime,jdbcType=TIMESTAMP}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Cart record);
}