package com.peace.bean;

import java.util.Date;

public class Item {
	private int id;
	private String title;
	private String body;
	private Date inserted;
	private String userId;
	private String userNickName;

	@Override
	public String toString() {
		return "Item [id=" + id + ", title=" + title + ", body=" + body + ", inserted=" + inserted + "]";
	}
	
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setInserted(Date inserted) {
		this.inserted = inserted;
	}

	public Date getInserted() {
		return inserted;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
