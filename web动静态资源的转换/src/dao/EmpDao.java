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
}
