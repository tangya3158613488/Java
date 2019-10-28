import Java代码.Student.*;
class Student{
	String name;
	int age;
	Student(String name,int age)
	{
		this.name = name;
		this.age = age;
	}
	void LearnMethod()
	{
		System.out.println("我是一名学生，我的学习方法是：认真听课。");
	}
	void Display()
	{
		System.out.println("我的名字是："+name+" "+"我的年龄是："+age);
	}
}
package ch4.Student;
class Undergraduate extends Student{
	String major,degree;
	Undergraduate(String name,int age,String major,String degree)
	{
		super(name,age);
		this.major = major;
		this.degree = degree;
	}
	void LearnMethod()
	{
		System.out.println("我是一名本科生，我的学习方法是：多看书，多动手。");
	}
	void Display()
	{
		System.out.println("我的名字是："+name+" "+"我的年龄是："+age+" "+"我的专业是："+major+" "+"我有学位："+degree);
	}
}
class Graduate extends Undergraduate{
	String researchdirection;
	Graduate(String name,int age,String major,String degree,String researchdirection)
	{
		super(name,age,major,degree);
		this.researchdirection = researchdirection;
	}
	void LearnMethod()
	{
		System.out.println("我是一名研究生，我的学习方法是：多查看资料，多实验。");
	}
	void Display()
	{
		System.out.println("我的名字是："+name+" "+"我的年龄是："+age+" "+"我的专业是："+major+" "+"我有学位："+degree+" "+"我的研究方向是："+researchdirection);
	}
}
import ch4.Student.Graduate;
import ch4.Student.Student;
import ch4.Student.Undergraduate;

class Test7{
	public static void main(String[] args){
		Student s = new Student("张三",20);
		s.LearnMethod();
		s.Display();
		Undergraduate u = new Undergraduate("李四",21,"信息管理与信息系统","学士学位");
		u.LearnMethod();
		u.Display();
		Graduate g = new Graduate("王五",19,"互联网金融","硕士学位","互联网和金融");
		g.LearnMethod();
		g.Display();
		
	}
}