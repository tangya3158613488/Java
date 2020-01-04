package exercise20_1_4;

class SuperA {
	public int getNumber(int a){
		return a+5;
	}
}
class Ex extends SuperA{
	public int getNumber(int a){
		return a+200;
	}
}
public class Example2 {
	public static void main(String args[]){
		Ex b=new Ex();
		System.out.println(b.getNumber(20));
	}
}
