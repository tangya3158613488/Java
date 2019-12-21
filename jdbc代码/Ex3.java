import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Ex3 {
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
    ResultSet  rs=sql.executeQuery("SELECT name,english FROM chengjibiao");
    	             rs.last();
    	             int number=rs.getRow();
    	             System.out.println("该表共有"+number+"条记录");
    	             rs.afterLast();
    	             while(rs.previous())
    	             { String  name=rs.getString("name");  
    	               int  english=rs.getInt("english");
    	               System.out.print("  姓名："+name);
    	               System.out.println("  英语："+english);
    	             }
    	            System.out.println("单独输出第2条记录:");
    	            rs.absolute(2);
    	            String  name=rs.getString("name");  
    	            int  english=rs.getInt("english");
    	            System.out.print("  姓名："+name);
    	            System.out.println("  英语："+english);
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
