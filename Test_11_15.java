package Exercise;

import java.util.Scanner;

public class Test_11_15 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.println(" 除法运算，输入两个整数： ");
		int first = in.nextInt();
		int second = in.nextInt();
		int result;
		try{
		result = first / second;
		System.out.println(result); }
		finally{
			System.out.println("默认处理");}
		System.out.println("结束");
		}
	}
