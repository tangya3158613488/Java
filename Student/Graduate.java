package ch4.Student;

public class Graduate extends Undergraduate{
	String researchdirection;
	public Graduate(String name,int age,String major,String degree,String researchdirection)
	{
		super(name,age,major,degree);
		this.researchdirection = researchdirection;
	}
	public void LearnMethod()
	{
		System.out.println("我是一名研究生，我的学习方法是：多查看资料，多实验。");
	}
	public void Display()
	{
		System.out.println("我的名字是："+name+" "+"我的年龄是："+age+" "+"我的专业是："+major+" "+"我有学位："+degree+" "+"我的研究方向是："+researchdirection);
	}
}
