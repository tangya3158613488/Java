package com.Mywork.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;




public class DAO {
	//学生登录功能
	public Student login(Connection con,Student stu)throws Exception{
		PreparedStatement ps = con.prepareStatement("select * from student where userId=? and userPwd=?");
		ps.setString(1, stu.getUserid());
		ps.setString(2, stu.getUserpwd());
		ResultSet rs = ps.executeQuery();
		Student resultUser = null;
		if(rs.next()){
			resultUser = new Student();
			resultUser.setUserid(rs.getString("userId"));
			resultUser.setUserpwd(rs.getString("userPwd"));
		}
		return resultUser;
	}
	
	public Admin login(Connection con,Admin ad)throws Exception{
		PreparedStatement ps = con.prepareStatement("select * from admin where userName=? and userPwd=?");
		ps.setString(1, ad.getUserid());
		ps.setString(2, ad.getUserpwd());
		ResultSet rs = ps.executeQuery();
		Admin resultUser = null;
		if(rs.next()){
			resultUser = new Admin();
			resultUser.setUserid(rs.getString("userId"));
			resultUser.setUserpwd(rs.getString("userPwd"));
		}
		return resultUser;
	}
	 public boolean regist(Connection con,Student stu) throws Exception{
	        boolean flag=false;
	        PreparedStatement ps = null;
	        ps = con.prepareStatement("insert into student(userId,userPwd)values(?,?)");
	        ps.setString(1, stu.getUserid());
	        ps.setString(2, stu.getUserpwd());
	        if (ps.executeUpdate() > 0) {
	            flag = true;
	        }
	        return flag;
	    }
	public ArrayList<Report> selectAll(int current,int size){
		ArrayList<Report> list=new ArrayList<Report>();
		Connection con = null;
		try {
			PreparedStatement ps = con.prepareStatement("select * from report limit ?,?");
			ps.setInt(1,(current-1)*size);
			ps.setInt(2, size);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				String dorId = rs.getString("dorId");
				String equipId = rs.getString("equipId");
				String equipName = rs.getString("equipName");
				Date reportDate = rs.getDate("reportDate");
				String reportreason = rs.getString("reportReason");
				Report e = new Report(dorId,equipId,equipName,reportDate,reportreason);
				list.add(e);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}

