package com.example.demo.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
 
@Override
	public String toString() {
		return "User [id=" + id + ", usrNam=" + usrNam + ", userId=" + userId + ", age=" + age + ", sex=" + sex
				+ ", address=" + address + ", birth=" + birth + ", password=" + password + ", usrGj=" + usrGj + "]";
	}
private int id;
  private String usrNam;
  private String userId;
  private int age;
  private String sex;
  private String address;
  private Date birth;
  private String password;
  private String usrGj;
public String getUsrGj() {
	return usrGj;
}
public void setUsrGj(String usrGj) {
	this.usrGj = usrGj;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public User(int id, String usrNam, String userId, int age, String sex, String address, Date birth, String password,String usrGj) {
	super();
	this.id = id;
	this.usrNam = usrNam;
	this.userId = userId;
	this.age = age;
	this.sex = sex;
	this.address = address;
	this.birth = birth;
	this.password = password;
	this.usrGj=usrGj;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUsrNam() {
	return usrNam;
}
public void setUsrNam(String usrNam) {
	this.usrNam = usrNam;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Date getBirth() {
	return birth;
}
public void setBirth(Date birth) {
	this.birth = birth;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
