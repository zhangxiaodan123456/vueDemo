package com.example.demo.dao;
import java.util.List;

import com.example.demo.domain.LoginInfo;

public interface LoginInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LoginInfo record);

    LoginInfo selectByPrimaryKey(Long id);

    List<LoginInfo> selectAll();

    int updateByPrimaryKey(LoginInfo record);
    /**
	 * 根据用户名查询用户数量
	 * 
	 * @param username
	 * @return
	 */
	int getCountByUsername(String username);
}