package com.peace.bean;

public class User {
	private String id;
	private String password;
	private String nickName;
	private String email;
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", nickName=" + nickName + ", email=" + email + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
