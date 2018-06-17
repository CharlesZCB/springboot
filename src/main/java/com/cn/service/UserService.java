package com.cn.service;

import com.cn.entity.User;
import com.cn.dao.UserMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapping userMapping;

    public void InsertOne(String id,String name, Integer age) {
        userMapping.insertOne(id,name,age);
    }

    public List<User> getAll() {
      return userMapping.getAll();
    }

    public void deleteById(String id) {
        userMapping.deleteById(id);
    }
}
