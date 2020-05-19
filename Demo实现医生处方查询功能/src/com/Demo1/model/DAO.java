package com.Demo1.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Demo1.model.User;


public class DAO {
    /**
     * login(Connection con,User user) 登录验证
     * (Connection con,User user)注册功能
  
     */
    public User login(Connection con,User user) throws Exception{
        User resultUser=null;
        PreparedStatement ps=con.prepareStatement("select * from userInfo where userName=? and userPwd=?");
        ps.setString(1, user.getUserName());
        ps.setString(2, user.getUserPwd());
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            resultUser=new User();
            resultUser.setUserName(rs.getString("userName"));
            resultUser.setUserPwd(rs.getString("userPwd"));
        }
        return resultUser;
    }
    
    //注册功能
    public boolean regist(Connection con,User user) throws Exception{
        boolean flag=false;
        PreparedStatement ps = null;
        ps = con.prepareStatement("insert into userInfo(userName,userPwd)values(?,?)");
        ps.setString(1, user.getUserName());
        ps.setString(2, user.getUserPwd());
        if (ps.executeUpdate() > 0) {
            flag = true;
        }
        return flag;
    }
 //根据拼音名查找医生信息
    public Doctor findByPym(String pym) throws Exception{
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        Doctor doc = null;
        conn = DbUtil.getConnection();
        ps = conn.prepareStatement("select *from tb_doctor where pym=?");
        ps.setString(1, pym);
        rs = ps.executeQuery();
        if(rs.next()){
        	doc = new Doctor();
        	doc.setID(rs.getInt("ID"));
        	doc.setDname(rs.getString("dname"));
        	doc.setDept(rs.getString("dept"));
        	doc.setPym(rs.getString("pym"));
  
        }
        return doc;
    }
    
    
    //根据医生id查找该医生的所有处方
    public List<Chufang> findByDoctorId(int doctorId) throws Exception{
    	ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        List<Chufang> list = new ArrayList<Chufang>();
        conn = DbUtil.getConnection();
        ps = conn.prepareStatement("select *from tb_chufang where doctorId=?");
        ps.setInt(1, doctorId);
        rs = ps.executeQuery();
        while(rs.next()){
        	Chufang c= new Chufang();
        	c.setID(rs.getInt("ID"));
        	c.setChufangID(rs.getString("chufangID"));
        	c.setDoctorId(rs.getInt("doctorId"));
        	c.setChufangDate(new Date(rs.getDate("chufangDate").getTime()));
        	c.setMoney(rs.getFloat("money"));
        	c.setIsVerify(rs.getInt("isVerify"));
        	list.add(c);
  
        }
        return list;
    }
}
