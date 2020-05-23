package com.Mywork.model;

public class Admin {
	private String userid;
	private String userpwd;
	
	public Admin(){}

	public Admin(String userid, String userpwd) {
		this.userid = userid;
		this.userpwd = userpwd;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	
}
