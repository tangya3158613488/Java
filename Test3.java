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

