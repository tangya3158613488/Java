import java.sql.*;
public class Ex1 {
 public static void main(String [] args)
 {
  String driverName="com.mysql.jdbc.Driver";
  String dbURL="jdbc:mysql://localhost:3306/student"; //���ݿ���Ϊstudent
  String userName="root";
  String userPwd="123456";
  try
  {
   Class.forName(driverName);
   Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
    System.out.println("�������ݿ�ɹ�");
    Statement sql=dbConn.createStatement();
    ResultSet  rs=sql.executeQuery("SELECT * FROM chengjibiao");
        while(rs.next())
        { String  number=rs.getString(1);
          String  name=rs.getString(2);  
          String  date=rs.getString(3);
          int     math=rs.getInt("math");
          int     english=rs.getInt("english"); 
          System.out.print("ѧ�ţ�"+number); 
          System.out.print("  ������"+name);
          System.out.print("  ������"+date);
          System.out.print("  ��ѧ��"+math);
          System.out.println("  Ӣ�"+english);
        }
        rs.close();
        sql.close();
        dbConn.close();
      }
   catch(Exception e)
  {
   e.printStackTrace();
   System.out.print("���ݿ����ʧ��");
  }     
 }
