import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Ex5 {
 public static void main(String [] args)
 {
  String driverName="com.mysql.jdbc.Driver";
  String dbURL="jdbc:mysql://localhost:3306/student";
  String userName="root";
  String userPwd="123456";
  try
  {
   Class.forName(driverName);
   Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
    System.out.println("连接数据库成功");
    Statement sql= dbConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
    ResultSet  rs=sql.executeQuery("SELECT name,math FROM chengjibiao WHERE name LIKE '%张%' ");
    while(rs.next())
    { String  name=rs.getString(1);  
      int  math=rs.getInt(2);
      System.out.print("  姓名："+name);
      System.out.println("  数学："+math);
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

}
