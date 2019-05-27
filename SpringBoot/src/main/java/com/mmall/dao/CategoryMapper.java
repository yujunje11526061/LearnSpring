package com.mmall.dao;

import com.mmall.pojo.Category;
import org.apache.ibatis.annotations.*;


@Mapper
public interface CategoryMapper {
    @Delete({
        "delete from mmall_category",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into mmall_category (id, parent_id, ",
        "name, status, sort_order, ",
        "create_time, update_time)",
        "values (#{id,jdbcType=INTEGER}, #{parentId,jdbcType=INTEGER}, ",
        "#{name,jdbcType=VARCHAR}, #{status,jdbcType=BIT}, #{sortOrder,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(Category record);

    int insertSelective(Category record);

    @Select({
        "select",
        "id, parent_id, name, status, sort_order, create_time, update_time",
        "from mmall_category",
        "where id = #{id,jdbcType=INTEGER}"
    })
    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    @Update({
        "update mmall_category",
        "set parent_id = #{parentId,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=BIT},",
          "sort_order = #{sortOrder,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Category record);
}