import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Ex2 {
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
    System.out.println("�������ݿ�ɹ�");
    Statement sql=dbConn.createStatement();
    ResultSet rs=sql.executeQuery("SELECT name,english FROM chengjibiao WHERE english >= 70 ");
    while(rs.next())
    { String  name=rs.getString(1);  
      int  english=rs.getInt("english");
      System.out.print("  ������"+name);
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

}