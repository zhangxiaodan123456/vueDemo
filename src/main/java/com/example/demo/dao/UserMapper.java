package com.example.demo.dao;
import java.util.List;
import java.util.Map;

import com.example.demo.domain.User;

public interface UserMapper {
    List<User> list(Map map);
    
    public void add(Map map);
    
    public void edit(Map map);
    public void delete(String id);
}