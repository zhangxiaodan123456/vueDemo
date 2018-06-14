package com.example.demo.service;
import java.util.List;

import com.example.demo.domain.LoginInfo;

/**
 * 城市业务逻辑接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface LoginInfoService {
	List<LoginInfo> list();
	
	public int insert(LoginInfo log);
}
