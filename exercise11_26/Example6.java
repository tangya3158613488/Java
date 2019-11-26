package exercise11_26;

import java.awt.*;
import java.awt.event.*;
public class Example6
{
	public static void main(String[] args) 
	{   
		Frame frm=new Frame("我创建的一个窗口");
	    Label  lbl=new Label("Hello, World! I am label!",Label.CENTER);
		frm.setSize(300,250);
		frm.setLocation(100,100);
		frm.setLayout(null);   //把java默认的页面布局方式关掉，即设置为空布局
		lbl.setBounds(20,50,200,20); 
		frm.setBackground(Color.red);
		lbl.setBackground(Color.pink); 
		frm.add(lbl);
		frm.setVisible(true);
		frm.addWindowListener(new WindowAdapter() { 
          public void windowClosing(WindowEvent e){ 
                System.exit(0); } });
	}
}
