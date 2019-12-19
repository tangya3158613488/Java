package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;

import entity.Stu;

public class StuDao {
	
	public StuDao() {
		
	}

	public ArrayList<Stu> selectAll(){
		ArrayList<Stu> list = new ArrayList<Stu>();
	try{	
		new Driver();
		
		String url="jdbc:mysql://localhost:3306/emp_system?useUnicode=true&characterEncoding=utf8";
		String user="root";
		String password="";
		Connection con = (Connection) DriverManager.getConnection(url, user, password);
		

		String sql = "select * from t_student01";
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while(rs.next()){
			Stu stu = new Stu();
			int eId=rs.getInt("id");
			String eName = rs.getString("name");
			String eGender = rs.getString("gender");
			String eBirth = rs.getString("birth");
			String eClasses = rs.getString("classes");
			String ePhone = rs.getString("phone");
			String eQQ = rs.getString("qq");
			String eAddress = rs.getString("address");
			String eMessage = rs.getString("message");
		//	Stu e = new Stu(eId,eName,eGender,eBirth,eClasses,ePhone,eQQ,eAddress,eMessage);
			list.add(stu);	
		}	
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	return list;
	}
	
	
	public ArrayList<Stu> selectAll(int current,int size){
		ArrayList<Stu> list = new ArrayList<Stu>();
	try{	
		new Driver();
		
		String url="jdbc:mysql://localhost:3306/emp_system?useUnicode=true&characterEncoding=utf8";
		String user="root";
		String password="";
		Connection con = (Connection) DriverManager.getConnection(url, user, password);
		

		String sql = "select * from t_student01 limit ?,?";
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		
		ps.setInt(1, (current-1)*size);
		ps.setInt(2, size);
		
		
		ResultSet rs = ps.executeQuery();

		while(rs.next()){
			int eId=rs.getInt("id");
			String eName = rs.getString("name");
			String eGender = rs.getString("gender");
			String eBirth = rs.getString("birth");
			String eClasses = rs.getString("classes");
			String ePhone = rs.getString("phone");
			String eQQ = rs.getString("qq");
			String eAddress = rs.getString("address");
			String eMessage = rs.getString("message");
			Stu e = new Stu(eId,eName,eGender,eBirth,eClasses,ePhone,eQQ,eAddress,eMessage);
			list.add(e);
			
		}	
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	return list;
	
	
	}
	
	
public Stu selectOne(String name ,String classes){
		
		try {
			new Driver();
			String url="jdbc:mysql://localhost:3306/emp_system?useUnicode=true&characterEncoding=utf8";
			String user="root";
			String password="";
			Connection conn=(Connection) DriverManager.getConnection(url, user, password);
			// 把sql语句添加limit 其中两个参数用问号占位符定义
			String sql="select * from t_student01 where name=? and classes=?";
			PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);
			//把问号占位符用变量来表示，其中问号的位置从1开始，
			ps.setString(1, name);
			ps.setString(2, classes);
			ResultSet rs=ps.executeQuery();// DQL必须用jdbc的executeQuery
			if(rs.next()){
				int eId=rs.getInt("id");
				String eName = rs.getString("name");
				String eGender = rs.getString("gender");
				String eBirth = rs.getString("birth");
				String eClasses = rs.getString("classes");
				String ePhone = rs.getString("phone");
				String eQQ = rs.getString("qq");
				String eAddress = rs.getString("address");
				String eMessage = rs.getString("message");
				Stu e = new Stu(eId,eName,eGender,eBirth,eClasses,ePhone,eQQ,eAddress,eMessage);
				return e;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


public int deleteById(int eId){
	try{
		
		new Driver();
		String url="jdbc:mysql://localhost:3306/emp_system?useUnicode=true&characterEncoding=utf8";
		String user="root";
		String password="";
		Connection conn=(Connection) DriverManager.getConnection(url, user, password);
		String sql="delete from t_student01 where id=?";
		PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);
		ps.setInt(1,eId);
		int result=ps.executeUpdate();// jdbc中规定DML语句全用executeUpdate方法进行提交到数据库  Insert  update  delete  
		return result;
	}catch(Exception e){
		e.printStackTrace();
		return -1;
	}
}




public Stu selectOne(int Id) {
	
	try {
		new Driver();
		String url="jdbc:mysql://localhost:3306/emp_system?useUnicode=true&characterEncoding=utf8";
		String user="root";
		String password="";
		Connection conn=(Connection) DriverManager.getConnection(url, user, password);
		// 把sql语句添加limit 其中两个参数用问号占位符定义
		String sql="select * from t_student01 where id=?";
		PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);
		//把问号占位符用变量来表示，其中问号的位置从1开始，
		ps.setInt(1, Id);
		
		ResultSet rs=ps.executeQuery();// DQL必须用jdbc的executeQuery
		if(rs.next()){
			int eId=rs.getInt("id");
			String eName = rs.getString("name");
			String eGender = rs.getString("gender");
			String eBirth = rs.getString("birth");
			String eClasses = rs.getString("classes");
			String ePhone = rs.getString("phone");
			String eQQ = rs.getString("qq");
			String eAddress = rs.getString("address");
			String eMessage = rs.getString("message");
			Stu e = new Stu(eId,eName,eGender,eBirth,eClasses,ePhone,eQQ,eAddress,eMessage);
			return e;
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;

	}



public int updateById(Stu e) {
	try {
		new Driver();
	
	String url="jdbc:mysql://localhost:3306/emp_system?useUnicode=true&characterEncoding=utf8";
	String user="root";
	String password="";
	Connection con = (Connection) DriverManager.getConnection(url, user, password);
	String sql = "update t_student01 set phone=?,qq=?,address=? where id=?";
	PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);

	ps.setString(1,e.getPhone());
	ps.setString(2, e.getQq());
	ps.setString(3, e.getAddress());
	ps.setInt(4, e.getId());
	
									
		return ps.executeUpdate();		
	
	} catch (SQLException e1) {
		
		e1.printStackTrace();
		return -1;
	}
}


public boolean insertInto(Stu e) {
	try {
		new Driver();
	
	String url="jdbc:mysql://localhost:3306/emp_system?useUnicode=true&characterEncoding=utf8";
	String user="root";
	String password="";
	Connection con = (Connection) DriverManager.getConnection(url, user, password);
	String sql = "insert into t_student01(id,name,gender,birth,classes,"
			+ "phone,qq,address,message) values(?,?,?,?,?,?,?,?,?)";
	PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
	ps.setInt(1, e.getId());
	ps.setString(2, e.getName());
	ps.setString(3, e.getGender());
	ps.setString(4, e.getBirth());
	ps.setString(5, e.getClasses());
	ps.setString(6, e.getPhone());
	ps.setString(7, e.getQq());
	ps.setString(8, e.getAddress());
	ps.setString(9, e.getMessage());
	int count = ps.executeUpdate();
	ps.close();
	return count > 0 ? true : false;
			
	
	} catch (SQLException e1) {
		
		e1.printStackTrace();
	}
	return false;

}
}

