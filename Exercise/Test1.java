package Exercise;


//编写应用程序，实现main方法中String[ ] args参数参与程序的运算，传入三个整型参数求出最值并输出。
public class Test1 {
public static void main(String[] args) {
	int x = Integer.parseInt(args[0]);
	int y = Integer.parseInt(args[1]);
	int z = Integer.parseInt(args[2]);
	int max;
	if(x > y && x > z)
	{
		max = x;
	}
	else if(y > z && y > x)
	{
		max = y;
	}
	else
	{
		max = z;
	}
	System.out.println("x,y,z中最大的整数为：max = "+max);
}
}
