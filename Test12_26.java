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
		{ System.out.println("��ѧ������");
		}
		else
		{ System.out.println("��ѧ������");
		}
		if(english>90)
		{ System.out.println("Ӣ������");
		}
		else
		{ System.out.println("Ӣ�ﲻ����");
		}
		System.out.println("����ѧϰ�����");
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
			System.out.println("û��ƥ���"+(x+y));
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
			if(i%2==0) //����1+3+5+7+9
				continue;
			sum=sum+i;
		}
		System.out.println("sum="+sum);
		for(j=2;j<=50;j++) //��50���ڵ�����
		{
			for( i=2;i<=j/2;i++)
			{
				if(j%i==0)
					break;
			}
			if(i>j/2)
			{ 
				System.out.println(""+j+"������");
			}
		}
	}
}

import java.util.*;
public class Test2 {
	public static void main(String args[ ]){
		float score;
		Scanner in=new Scanner(System.in);
		System.out.println("������һ������ ��");
		score=in.nextFloat();
		if(score>100)
		{
			System.out.println("��������ֲ��ڷ�Χ�ڣ����������룡");
		}
		else
		{
			switch ((int)score/10)
			{
			case 10:
			case 9:
				System.out.println("�ɼ�Ϊ����"); break;
			case 8:
				System.out.println("�ɼ�Ϊ����"); break;
			case 7:
				System.out.println("�ɼ�Ϊ�е�"); break;
			case 6:
				System.out.println("�ɼ�Ϊ����"); break;
			default: 
				System.out.println("�ɼ�������"); break;
			}
		}
	}
}
public class Test2 {
	public static void main(String[] args) {
		System.out.println("main()������ʼִ��");
		method( );
		System.out.println("main()��������ִ��");
}
	public static void method(){
	System.out.println("method()������ʼִ��");
	for(int i=0;i<5;i++)
	{
		if(i==3)
		{
			return;
		}
		System.out.println("i="+i); 
	}
	System.out.println("method()��������ִ��");
	}
}





























