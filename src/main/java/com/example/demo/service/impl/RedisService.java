package com.example.demo.service.impl;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
	@Autowired
	private RedisTemplate redisTemplate;
	
	public void setValue(String key,String value){
		redisTemplate.opsForValue().set(key,value);
	}
	
	public Object getValue(String key){
		return redisTemplate.opsForValue().get(key);
	}
	
	public void setHash(String key,Map map){
		redisTemplate.opsForHash().putAll(key, map);
	}
	
	public Map getHash(String key){
		return redisTemplate.opsForHash().entries(key);
	}
	
	public void setSet(String key,String str){
		redisTemplate.opsForSet().add(key,str);
	}
	
	public Set getSet(String key){
		return redisTemplate.opsForSet().members(key);
	}
	
	
	public void setList(String key,String str){
		redisTemplate.opsForList().leftPush(key, str);
	}
	
	public List getList(String key,int start,int end){
		return redisTemplate.opsForList().range(key, start, end);
	}
}
