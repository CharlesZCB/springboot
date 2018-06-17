package com.cn.dao;

import com.cn.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapping {
    @Select("select * from userb where id=#{id}")
    User getById(@Param("id")String id);

    @Insert("insert into userb(id,name,age,st) values(#{id},#{name},#{age},now())")
    void insertOne(@Param("id")String id,@Param("name")String name,@Param("age")Integer age);

    @Select("select * from userb order by st desc")
    List<User> getAll();

    @Delete("delete from userb where id=#{id}")
    void deleteById(@Param("id") String id);
}
