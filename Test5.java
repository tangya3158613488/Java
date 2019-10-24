class Address {
	String name ,phonenumber ;
	String email;
	void display(String name,String phonenumber,String email)
	{
		System.out.println("name: "+name);
		System.out.println("phonenumber: "+phonenumber);
		System.out.println("email: "+email);
	}
	
}
public class Test5{
	public static void main(String[] args){
		String name ,phonenumber,email;
		Address ar1 = new Address();
		Address ar2 = new Address();
		Address ar3 = new Address();
		ar1.display("张三","1234567890","1234567@qq.com");
		ar2.display("李四","1234567891","1234568@qq.com");
		ar3.display("王五","1234567892","1234563@qq.com");
	}
}