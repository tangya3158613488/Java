package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Driver;

import entity.Emp;

public class EmpDao {
	public ArrayList<Emp> selectAll(int current,int size){
		ArrayList<Emp> list=new ArrayList<Emp>();
		try {
			new Driver();
			String url="jdbc:mysql://localhost:3306/emp_system?useUnicode=true&characterEncoding=utf-8";
			//emp_system是动态传入参数
			String user="root";
			String password="";
			Connection con=DriverManager.getConnection(url,user,password);
			
			String sql="select * from t_emp limit ?,?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,(current-1)*size);
			ps.setInt(2, size);
			
			ResultSet rs=ps.executeQuery();// DQL必须用jdbc的executeQuery
			
			while(rs.next()){
				int eId=rs.getInt("id");
				String eName=rs.getString("name");
				String ePhone=rs.getString("phone");
				String eEmpNo=rs.getString("empno");
				String eGender=rs.getString("gender");
				int eAge=rs.getInt("age");
				Emp e=new Emp(eId,eName,eGender,ePhone,eEmpNo,eAge);
				list.add(e);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public Emp selectOne(String name,String empno) {
		try{
				new Driver();
				String url="jdbc:mysql://localhost:3306/emp_system?useUnicode=true&characterEncoding=utf-8";
				String user="root";
				String password="";
				Connection con=DriverManager.getConnection(url,user,password);
				String sql="select * from t_emp where name=? and empno=?";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2, empno);
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
					String eName=rs.getString("name");
					int id=rs.getInt("id");
					Emp e=new Emp();
					e.setId(id);
					e.setName(eName);
					return e;
				}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public int deleteById(int eId){
		try{
			new Driver();
			String url="jdbc:mysql://localhost:3306/emp_system?useUnicode=true&characterEncoding=utf-8";
			String user="root";
			String password="";
			Connection conn=DriverManager.getConnection(url,user,password);
			String sql="delete from t_emp where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, eId);
			int result=ps.executeUpdate();
			return result;
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}


	public Emp selectOne(int eId) {
		try{
			new Driver();
			String url="jdbc:mysql://localhost:3306/emp_system?useUnicode=true&characterEncoding=utf-8";
			String user="root";
			String password="";
			Connection con=DriverManager.getConnection(url,user,password);
			String sql="select * from t_emp where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, eId);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				String eName=rs.getString("name");
				String ePhone=rs.getString("phone");
				String eEmpNo=rs.getString("empno");
				String eGender=rs.getString("gender");
				int eAge=rs.getInt("age");
				Emp e=new Emp(eId,eName,eGender,ePhone,eEmpNo,eAge);
				return e;
			}
	}catch(SQLException e){
		e.printStackTrace();
	}
		return null;
	}
	
	public int updateById(Emp e){
		
		try{
			new Driver();
			String url="jdbc:mysql://localhost:3306/emp_system?useUnicode=true&characterEncoding=utf8";
			String user="root";
			String password="";
			Connection con=DriverManager.getConnection(url,user,password);
			String sql="update t_emp set name=?,age=?,gender=?,empno=?,phone=? where id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, e.getName());
			ps.setInt(2, e.getAge());
			ps.setString(3, e.getGender());
			ps.setString(4,e.getEmpNo());
			ps.setString(5, e.getPhone());
			ps.setInt(6, e.getId());
			return ps.executeUpdate();
		}catch(SQLException e1){
			e1.printStackTrace();
			return -1;
		}
	}
}
