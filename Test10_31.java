package p2;
class A{
	double f(int x,double y){
		return x+y;
	}
	int f(int x,int y){
		return x*y;
	}
}
public class Test1 {
public static void main(String[] args) {
	A a = new A();
	System.out.println(a.f(10, 10));
	System.out.println(a.f(10, 10.0));
}
}

package p2;
class AA{
	double f(double x,double y){
	return x+y;
	}
}
class B extends AA{
	double f(int x,int y){
		return x*y;
	}
} 
public class Test2 {
public static void main(String[] args) {
	B b = new B();
	System.out.println(b.f(3, 5));
	System.out.println(b.f(3.0,5.0));
}
}

package p2;
public class Test3{
	public static void main(String[] args) {
		CCircle.count();
		CCircle cirl = new CCircle(2.0);
		CCircle.count();
		CCircle cir2 = new CCircle(3.0);
		CCircle.count();
	}
}
class CCircle{
	private static int num = 0;
	public CCircle(double r){
		num++;
	}
	public static void count(){
		System.out.println("num="+num);
	}
}
package p2;
class A1{
	public int getNumber(int a){
		return a+1;
	}
}
 class Test4 extends A1 {
	 public int getNumber(int a){
		 return a+100;
	 }
	 public static void main(String[] args) {
		Test4 b = new Test4();
		System.out.println(b.getNumber(10));
	}
}
package p2;

public class Test5 {
	public static void main(String args[]){
		String strOne = "bird";
		String strTwo = strOne;
		strOne = "fly";
		System.out.println(strOne);
		System.out.println(strTwo);
	}
}
