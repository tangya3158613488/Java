package exercise20_1_4;

import java.io.*;
public class App7_2
{
	public static void main(String args[]) throws IOException {
		char data[]=new char[1024];
		FileReader fr=new FileReader("E:\\Java课程资料\\Java课件");
		
		int num=fr.read(data);
		String str=new String(data,0,num);
		System.out.println("Character read= "+num);
		System.out.println(str);
		fr.close();
		}
}
