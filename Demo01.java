package day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * ����jdbc�����ڿ���̨����emp���е���������
 */
public class Demo01 {
	public static void main(String[] args) throws Exception{
		//1.ע������
		Class.forName("com.mysql.jdbc.Driver");
		//2.��������
		String url = "jdbc:mysql://localhost:3306/t_umsl?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "";
		Connection conn = DriverManager.getConnection(url,user,password);
		//��׮
		System.out.println(conn);
		//дsql���
		String sql = "select * from emp";
		//����PreparedStatement����
		PreparedStatement ps = conn.prepareStatement(sql);
		//����ResultSet���󲢷��ؽ����
		ResultSet rs = ps.executeQuery();
		//���������
		while(rs.next())
		{
			int id = rs.getInt("id");
			String username = rs.getString("username");
			String pwd = rs.getString("password");
			String email = rs.getString("email");
			System.out.println(id+" "+username+" "+pwd+" "+email);
		}
	}
}
