package p1;

public class Test2 {
public static void main(String[] args) {
	StringBuffer s =new StringBuffer("学习Java语言");
	System.out.println(s);
	s.reverse();
	System.out.println(s);
	char[] d;
	d = new char[s.length()];
	s.getChars(0,8,d,0);
	System.out.println(s.length());
	System.out.println(d.length);
}
}
