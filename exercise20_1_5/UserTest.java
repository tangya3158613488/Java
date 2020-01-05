package exercise20_1_5;

class User{
	String name,command;
	static int number = 0;
	public User()
	{
		number++;         
	}
	public User(String name)
	{
		this.name = name;
		number++;
	}
	public User(String name,String command)
	{
		this.name = name;
		this.command = command;
		number++;
	}
	void setname(String name)
	{
		name = this.name;
	}
	String getname()
	{
		return name;
	}
	void setcommand(String command)
	{
		command = this.command;
	}
	String getcommand()
	{
		return command;
	}
	int getnumber()
	{
		return number;
	}
	void DisplayUserInfo()
	{
		System.out.println("姓名："+name+" "+"口令："+command+" "+"用户数量"+number);
	}
}
class UserTest{
	public static void main(String[] args)
	{
		User u1 = new User();
		u1.DisplayUserInfo();
		User u2 = new User("张三");
		u2.DisplayUserInfo();
		User u3 = new User("李四","odb3bf");
		u3.DisplayUserInfo();
	}
}
