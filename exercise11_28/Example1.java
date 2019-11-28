package exercise11_28;

import java.awt.*;
import java.awt.event.*;
class MyCheckbox extends Frame {
	 String city[]={"桂林","福州","青岛","济南","深圳","大连"};
	 Checkbox c[] = new Checkbox[6];
		 MyCheckbox()
	   {    setLayout(new FlowLayout());
                add(new Label("这是一个复选框的例子"));
		add(new Label("请选择是省会的城市: "));
		for(int i=0;i<6;i++){
		c[i]=new Checkbox(city[i]);
		add(c[i]);
		}
		
         setBounds(100,100,170,290);
         setVisible(true);
 addWindowListener(new WindowAdapter() { 
          public void windowClosing(WindowEvent e){ 
                System.exit(0); } });
	}
}
public class Example1{
public static void main(String args[])
{ new MyCheckbox();
}
}
