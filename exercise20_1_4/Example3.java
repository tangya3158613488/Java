package exercise20_1_4;

public class Example3{
	
	public static void main(String args[]){
		String str=new String("Java technology");
		Example3.modify(str);
		System.out.println(str);
	}
	public static void modify(String s){
		System.out.println(s+"课程");
	}
}

