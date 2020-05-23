package com.Mywork.model;

public class Student {
	private String userId;
	private String userPwd;
	
	public Student(){}

	public Student(String userid, String userpwd) {
		this.userId = userid;
		this.userPwd = userpwd;
	}

	public String getUserid() {
		return userId;
	}

	public void setUserid(String userid) {
		this.userId = userid;
	}

	public String getUserpwd() {
		return userPwd;
	}

	public void setUserpwd(String userpwd) {
		this.userPwd = userpwd;
	}
	
}
