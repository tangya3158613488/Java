public class Test2{
	public static void main(String args[]){
		int a=9,b=5,c=7,t;
		if(a>b)
		{ t=a; a=b; b=t; }
		if(a>c)
		{ t=a; a=c; c=t; }
		if(b>c)
		{ t=b; b=c; c=t;}
		System.out.println("a="+a+",b="+b+",c="+c);
	}
}*/
public class Test2{
	public static void main(String args[]){
		int math=65 ,english=85;
		if(math>60)
		{ System.out.println("数学及格了");
		}
		else
		{ System.out.println("数学不及格");
		}
		if(english>90)
		{ System.out.println("英语是优");
		}
		else
		{ System.out.println("英语不是优");
		}
		System.out.println("我在学习控语句");
	}
}
public class Test2{
	public static void main(String args[]){
		int x=2,y=1;
		switch(x+y)
		{
		case 1:
			System.out.println(x+y);
		case 3:
			System.out.print(x+y);
			break;
		case 0:
			System.out.println(x+y);
			break;
		default:
			System.out.println("没有匹配的"+(x+y));
		}
	}
}
public class Test2{
	public static void main(String args[]){
		long sum=0,a=5,item=a,n=10,i=1;
		for(i=1;i<=n;i++)
		{
			sum += item;
			item =item*10+a;
		}
		System.out.println(sum);
	}
}

public class Test2{
	public static void main(String args[]){
		double sum=0,a=1;
		int i=1;
		while(i<=20)
		{
			sum += a;
			i++;
			a *= (1.0)/i;
		}
		System.out.println("sum="+sum);
	}
}
public class Test2{
	public static void main(String args[]){
		int sum=0,i,j;
		for( i=1;i<=10;i++)
		{ 
			if(i%2==0) //计算1+3+5+7+9
				continue;
			sum=sum+i;
		}
		System.out.println("sum="+sum);
		for(j=2;j<=50;j++) //求50以内的素数
		{
			for( i=2;i<=j/2;i++)
			{
				if(j%i==0)
					break;
			}
			if(i>j/2)
			{ 
				System.out.println(""+j+"是素数");
			}
		}
	}
}

import java.util.*;
public class Test2 {
	public static void main(String args[ ]){
		float score;
		Scanner in=new Scanner(System.in);
		System.out.println("请输入一个数字 ：");
		score=in.nextFloat();
		if(score>100)
		{
			System.out.println("输入的数字不在范围内，请重新输入！");
		}
		else
		{
			switch ((int)score/10)
			{
			case 10:
			case 9:
				System.out.println("成绩为优秀"); break;
			case 8:
				System.out.println("成绩为良好"); break;
			case 7:
				System.out.println("成绩为中等"); break;
			case 6:
				System.out.println("成绩为及格"); break;
			default: 
				System.out.println("成绩不及格"); break;
			}
		}
	}
}
public class Test2 {
	public static void main(String[] args) {
		System.out.println("main()方法开始执行");
		method( );
		System.out.println("main()方法结束执行");
}
	public static void method(){
	System.out.println("method()方法开始执行");
	for(int i=0;i<5;i++)
	{
		if(i==3)
		{
			return;
		}
		System.out.println("i="+i); 
	}
	System.out.println("method()方法结束执行");
	}
}





























