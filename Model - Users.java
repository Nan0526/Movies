package com.movie.model;

public class Users {
private String    username ;
private String    psw ;
private String    name ;
private String    nick ;
private int    age ;
private String    phone ; 
private float    money ;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPsw() {
	return psw;
}
public void setPsw(String psw) {
	this.psw = psw;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getNick() {
	return nick;
}
public void setNick(String nick) {
	this.nick = nick;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public float getMoney() {
	return money;
}
public void setMoney(float money) {
	this.money = money;
}
public Users(){}
public Users(String username, String psw, String name, String nick, int age, String phone, float money) {
	super();
	this.username = username;
	this.psw = psw;
	this.name = name;
	this.nick = nick;
	this.age = age;
	this.phone = phone;
	this.money = money;
} 
	
}
