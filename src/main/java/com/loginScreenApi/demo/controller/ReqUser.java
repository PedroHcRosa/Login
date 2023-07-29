package com.loginScreenApi.demo.controller;

public class ReqUser {

	private String user;
	private String password;
	
	public String getUser() {
		return user.strip();
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password.strip();
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
