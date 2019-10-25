class User{
	String name,command;
	int number = 0;
	public User()
	{
		this("哈哈","0000");
		//number++;
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
	void display()
	{
		System.out.println("用户信息："+name+"\t"+command);
		System.out.println("用户数量："+number);
	}
}
class Test6{
	public static void main(String[] args)
	{
		User u1 = new User();
		User u2 = new User("张三");
		User u3 = new User("李四","odb3bf");
		u1.display();
		u2.display();
		u3.display();
		
	}
}