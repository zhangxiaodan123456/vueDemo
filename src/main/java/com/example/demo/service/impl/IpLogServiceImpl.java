package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IplogMapper;
import com.example.demo.domain.Iplog;
import com.example.demo.service.IpLogService;

@Service
public class IpLogServiceImpl implements IpLogService{
	@Autowired
	IplogMapper iplogMapper;
	@Override
	public int insert(Iplog log) {
		return iplogMapper.insert(log);
	}

}
