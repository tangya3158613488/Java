import java.sql.*;
public class Ex6 {
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
    int math=99,english=0;
    String number="2003001",date,name,recode,updateStr,insertStr,delStr;
    updateStr=
    "UPDATE chengjibiao SET math ="+math+" WHERE number = "+"'"+number+"'";
    math=92; 
    english=66;
    number="160488";
    name="����";
    date="1999-12-28";
    recode=  "("+"'"+number+"'"+","+"'"+name+"'"+","+"'"+date+"'"+","+math+","+english+")";
    insertStr="INSERT INTO chengjibiao VALUES "+recode;
    delStr="DELETE FROM chengjibiao WHERE number = '2003004' ";
    sql.executeUpdate(updateStr);
    sql.executeUpdate(insertStr);
    sql.executeUpdate(delStr);
    ResultSet rs=sql.executeQuery("SELECT * FROM chengjibiao");
      while(rs.next())
      { number=rs.getString(1);
        name=rs.getString(2);  
        date=rs.getString(3);
        math=rs.getInt("math");
        english=rs.getInt("english"); 
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

}
