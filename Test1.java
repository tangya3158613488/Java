package p1;

public class Test1 {
	public static void main(String[] args) {
		String name = "I am a good student";
		System.out.println("name的长度是："+name.length());
		System.out.println("字符串的第一个字符是："+name.charAt(0));
		System.out.println("把student替换为teacher后的输出为："+name.replaceAll("student","teacher"));
	}
}
