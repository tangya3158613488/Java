import java.util.Scanner;
public class Employee{
	public static void main(String args[]){
		boolean keycollege=false,CJava=false;
		int age,workyear;
		Scanner jobseeker=new Scanner(System.in);
		System.out.println("����C��Java���ԣ�����yes����������no");
		String str1=jobseeker.next();
		if("yes".equals(str1))
			CJava=true;
		System.out.println("���빤�䣺");
		workyear=jobseeker.nextInt();
		System.out.println("�ص��ѧ��ҵ������yes����������no");
		String str2=jobseeker.next();
		if("yes".equals(str2))
			keycollege=true;
		System.out.println("�������䣺");
		age=jobseeker.nextInt();
		if((CJava==true)&&(workyear>=3)||(keycollege==true)&&age<35)
			System.out.println("��ϲ������������ӦƸ�ɹ�!");
		else
			System.out.println("���ź��㲻����������ӦƸʧ��");
	}
}
