import Java����.Student.*;
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
		System.out.println("����һ��ѧ�����ҵ�ѧϰ�����ǣ��������Ρ�");
	}
	void Display()
	{
		System.out.println("�ҵ������ǣ�"+name+" "+"�ҵ������ǣ�"+age);
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
		System.out.println("����һ�����������ҵ�ѧϰ�����ǣ��࿴�飬�ද�֡�");
	}
	void Display()
	{
		System.out.println("�ҵ������ǣ�"+name+" "+"�ҵ������ǣ�"+age+" "+"�ҵ�רҵ�ǣ�"+major+" "+"����ѧλ��"+degree);
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
		System.out.println("����һ���о������ҵ�ѧϰ�����ǣ���鿴���ϣ���ʵ�顣");
	}
	void Display()
	{
		System.out.println("�ҵ������ǣ�"+name+" "+"�ҵ������ǣ�"+age+" "+"�ҵ�רҵ�ǣ�"+major+" "+"����ѧλ��"+degree+" "+"�ҵ��о������ǣ�"+researchdirection);
	}
}
import ch4.Student.Graduate;
import ch4.Student.Student;
import ch4.Student.Undergraduate;

class Test7{
	public static void main(String[] args){
		Student s = new Student("����",20);
		s.LearnMethod();
		s.Display();
		Undergraduate u = new Undergraduate("����",21,"��Ϣ��������Ϣϵͳ","ѧʿѧλ");
		u.LearnMethod();
		u.Display();
		Graduate g = new Graduate("����",19,"����������","˶ʿѧλ","�������ͽ���");
		g.LearnMethod();
		g.Display();
		
	}
}