package ch4.Student;

public class Undergraduate extends Student{
	String major,degree;
	public Undergraduate(String name,int age,String major,String degree)
	{
		super(name,age);
		this.major = major;
		this.degree = degree;
	}
	public void LearnMethod()
	{
		System.out.println("我是一名本科生，我的学习方法是：多看书，多动手。");
	}
	public void Display()
	{
		System.out.println("我的名字是："+name+" "+"我的年龄是："+age+" "+"我的专业是："+major+" "+"我有学位："+degree);
	}
}
