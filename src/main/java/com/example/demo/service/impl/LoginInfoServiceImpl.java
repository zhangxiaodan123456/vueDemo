package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LoginInfoMapper;
import com.example.demo.domain.LoginInfo;
import com.example.demo.service.LoginInfoService;
/**
 * 城市业务逻辑接口类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class LoginInfoServiceImpl implements LoginInfoService{
	@Autowired
	LoginInfoMapper  loginInfoMapper;
	public List list() {
		return loginInfoMapper.selectAll();
	}
	@Override
	public int insert(LoginInfo log) {
	   	return loginInfoMapper.insert(log);
	}
}
