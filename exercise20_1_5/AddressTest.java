package exercise20_1_5;

class Address {
	String name ,phonenumber,email;
	public Address(String name,String phonenumber,String email){
		this.name = name;
		this.phonenumber = phonenumber;
		this.email = email;
	}
	public void display()
	{
		System.out.println("姓名："+name+" "+"电话号码："+phonenumber+" "+"电子邮件："+email);
	}
}
public class AddressTest{
	public static void main(String[] args){
		Address add1,add2;
		add1 = new Address("张华","14782637841","123@qq.com");
		add2 = new Address("李艳","15529366865","Li@qq.com");
		add1.display();
		add2.display();
	}
}
