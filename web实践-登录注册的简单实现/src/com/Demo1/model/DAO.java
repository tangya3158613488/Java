package com.Demo1.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
	public User login(Connection con,User user)throws Exception{
		User resultUser = null;
		PreparedStatement ps = con.prepareStatement("select * from userinfo where userName = ? and userPwd = ?");
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getUserPwd());
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			resultUser = new User();
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setUserPwd(rs.getString("userPwd"));
		}
		return resultUser;
	}
	public boolean register(Connection con,User user)throws Exception{
		boolean flag = false;
		PreparedStatement ps = con.prepareStatement("insert into userinfo(userName,userPwd) values(?,?)");
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getUserPwd());
		if(ps.executeUpdate() > 0){
			flag = true;
		}
		return flag;
	}
}
