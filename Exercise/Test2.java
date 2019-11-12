package Exercise;
//import java.util.*;
//使用System类中的方法，编程实现数组的快速复制并输出结果。
public class Test2 {
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7};
		int[] b = {8,9,10,11,12,13,14,15,16};
		System.arraycopy(a,0,b,0,a.length);
		for(int i = 0;i < b.length;i++)
		{
			System.out.print(" "+b[i]);
		}
	}
	
}
