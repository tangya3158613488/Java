import java.sql.*;
public class Ex1 {
 public static void main(String [] args)
 {
  String driverName="com.mysql.jdbc.Driver";
  String dbURL="jdbc:mysql://localhost:3306/student"; //数据库名为student
  String userName="root";
  String userPwd="123456";
  try
  {
   Class.forName(driverName);
   Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
    System.out.println("连接数据库成功");
    Statement sql=dbConn.createStatement();
    ResultSet  rs=sql.executeQuery("SELECT * FROM chengjibiao");
        while(rs.next())
        { String  number=rs.getString(1);
          String  name=rs.getString(2);  
          String  date=rs.getString(3);
          int     math=rs.getInt("math");
          int     english=rs.getInt("english"); 
          System.out.print("学号："+number); 
          System.out.print("  姓名："+name);
          System.out.print("  出生："+date);
          System.out.print("  数学："+math);
          System.out.println("  英语："+english);
        }
        rs.close();
        sql.close();
        dbConn.close();
      }
   catch(Exception e)
  {
   e.printStackTrace();
   System.out.print("数据库操作失败");
  }     
 }
