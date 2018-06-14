package com.example.demo.domain;


public class LoginInfo{
	
	@Override
	public String toString() {
		return "LoginInfo [id=" + id + ", username=" + username + ", password=" + password + ", state=" + state
				+ ", userType=" + userType + "]";
	}
	public static final int STATE_NORMAL = 0;// 正常
	public static final int STATE_LOCK = 1;// 锁定

	public static final int USER_MANAGER = 0;// 后台用户
	public static final int USER_CLIENT = 1;// 前台用户
     
    private Integer id;

    private String username;

    private String password;

    private int state;
    private int userType;
}