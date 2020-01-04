package exercise20_1_4;

public class Example1 {
	public static void main(String args[]){
		int n = 0, m = 0, t = 100;
		try{
			m=Integer.parseInt("888");
			n=Integer.parseInt("ab8");
			t=666;
		}catch(NumberFormatException e){
			System.out.println("Exception="+e);
		}
		System.out.println("n="+n+",m="+m+",t="+t);	
	}
}
