package exercise11_26;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class WindowTest extends Frame{
	TextField text1,text2;
	WindowTest(String s){
		super(s);
		setLayout(new FlowLayout());
		text1=new TextField("输入密码：",10);
		text1.setEditable(false);//不可编辑
		text2=new TextField(10);
		text2.setEchoChar('*');
		
		add(text1);
		add(text2);
;
		setBounds(100,100,300,290);
		setVisible(true);
		addWindowListener(new WindowAdapter() { 
	          public void windowClosing(WindowEvent e){ 
	                System.exit(0); } });}
}
public class Example4 {
public static void main(String[] args) {
	WindowTest win=new WindowTest("添加了文本框的窗口");
}
}
