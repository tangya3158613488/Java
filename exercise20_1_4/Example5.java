package exercise20_1_4;

class AA{
	double f(double x,double y){
		return x+y;  }
}
class B extends AA{
	double f(int x,int y){
		return x*y;  }
} 
public class Example5{
	public static void main(String args[]){
		B b=new B();
		System.out.println(b.f(2, 3));
		System.out.println(b.f(2.0, 3.0)); 
		}
}
