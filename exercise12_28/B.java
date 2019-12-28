package exercise12_28;

public class B{
	B(){
	this(12);
	System.out.println("bbb"); }
	B(int x){
	System.out.println("ccc"+x); }
	public static void main(String[]
	args){
	new B();
	}
	}