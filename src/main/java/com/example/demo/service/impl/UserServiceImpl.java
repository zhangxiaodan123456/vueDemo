package com.example.demo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserMapper;
import com.example.demo.domain.Iplog;
import com.example.demo.domain.LoginInfo;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;

/**
 * 城市业务逻辑接口类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userDao;
	public List<User> list(Map map){
		return userDao.list(map);
	}
	
	public void add(Map map) {
		userDao.add(map);
	}
	
	public void edit(Map map){
		userDao.edit(map);
	}
	
	public void delete(String id){
		userDao.delete(id);
	}
}
