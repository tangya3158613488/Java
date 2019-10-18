import java.util.Scanner;
public class Employee{
	public static void main(String args[]){
		boolean keycollege=false,CJava=false;
		int age,workyear;
		Scanner jobseeker=new Scanner(System.in);
		System.out.println("掌握C和Java语言，输入yes，否则输入no");
		String str1=jobseeker.next();
		if("yes".equals(str1))
			CJava=true;
		System.out.println("输入工龄：");
		workyear=jobseeker.nextInt();
		System.out.println("重点大学毕业，输入yes，否则输入no");
		String str2=jobseeker.next();
		if("yes".equals(str2))
			keycollege=true;
		System.out.println("输入年龄：");
		age=jobseeker.nextInt();
		if((CJava==true)&&(workyear>=3)||(keycollege==true)&&age<35)
			System.out.println("恭喜你满足条件，应聘成功!");
		else
			System.out.println("很遗憾你不满足条件，应聘失败");
	}
}
