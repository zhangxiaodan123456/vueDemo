package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.domain.Iplog;
import com.example.demo.domain.LoginInfo;
import com.example.demo.domain.User;

/**
 * 城市业务逻辑接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface UserService {
	List<User> list(Map map);
	public void add(Map map);
	public void edit(Map map);
	public void delete(String id);
}
