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
	public ArrayList<Emp> selectAll(){
		ArrayList<Emp> list=new ArrayList<Emp>();
		try {
			new Driver();
			String url="jdbc:mysql://localhost:3306/emp_system?useUnicode=true&characterEncoding=utf-8";
			String user="root";
			String password="";
			Connection con=DriverManager.getConnection(url,user,password);
			
			String sql="select * from t_emp";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				int eId=rs.getInt("id");
				String eName=rs.getString("name");
				String ePhone=rs.getString("phone");
				String eEmpNo=rs.getString("empno");
				int eAge=rs.getInt("age");
				Emp e=new Emp(eId,eName,ePhone,eEmpNo,eAge);
				list.add(e);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
