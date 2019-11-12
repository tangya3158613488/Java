package ch4.Student;

public class Student {
		String name;
		int age;
		public Student(String name,int age)
		{
			this.name = name;
			this.age = age;
		}
		public void LearnMethod()
		{
			System.out.println("我是一名学生，我的学习方法是：认真听课。");
		}
		public void Display()
		{
			System.out.println("我的名字是："+name+" "+"我的年龄是："+age);
		}
}
