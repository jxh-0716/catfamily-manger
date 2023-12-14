package com.catsystem.catfamilymanger.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.catsystem.catfamilymanger.pojo.User;

@Mapper
public interface UserMapper {
    @Select("select * from user where name = #{name}")
    User findByUsername(String name);

    @Insert("INSERT INTO user (name, password, gender, email, phonenumber, nickname) VALUES (#{name}, #{password}, #{gender}, #{email}, #{phonenumber}, #{nickname})")
    void register(String name, String password, String gender, String email, String phonenumber, String nickname);
}
