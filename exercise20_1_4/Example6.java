package exercise20_1_4;

public class Example6 {
	public static void main(String args[]){
		int elements[]={1,2,3,4};
		int hold[]={10,9,8,7,6,5,4,3,2,1};
		System.arraycopy(elements, 0, hold, 0, elements.length);
		System.out.println("长度为："+hold.length);
		for(int i=0; i < hold.length; i++)
			System.out.print(" "+hold[i]);
	}
}
