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
