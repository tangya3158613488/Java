package exercise20_1_4;

public class App7_1 {
	public static void main(String args[ ]){
		try{ int arr[ ]=new int[5];
		arr[10]=7;
	}
	catch(ArrayIndexOutOfBoundsException e){
		System.out.println("Exception="+e);
	}
		System.out.println("end of main() method!!");
	}
}
