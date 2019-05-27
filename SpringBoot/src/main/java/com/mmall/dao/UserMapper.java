package com.mmall.dao;

import com.mmall.pojo.User;
import org.apache.ibatis.annotations.*;


@Mapper
public interface UserMapper {
    @Delete({
        "delete from mmall_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into mmall_user (id, username, ",
        "password, email, ",
        "phone, question, ",
        "answer, role, create_time, ",
        "update_time)",
        "values (#{id,jdbcType=INTEGER}, #{username,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR}, #{question,jdbcType=VARCHAR}, ",
        "#{answer,jdbcType=VARCHAR}, #{role,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(User record);

    int insertSelective(User record);

    @Select({
        "select",
        "id, username, password, email, phone, question, answer, role, create_time, update_time",
        "from mmall_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    @Update({
        "update mmall_user",
        "set username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "question = #{question,jdbcType=VARCHAR},",
          "answer = #{answer,jdbcType=VARCHAR},",
          "role = #{role,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
}