package exercise11_26;

import java.awt.*;
import java.awt.event.*;
public class Exampe1{
	public static void main(String[] args) 
	{       
		Frame frm=new Frame("创建的一个窗口");
		frm.setSize(300,250);
		frm.setLocation(100,100);
		frm.setVisible(true);
		frm.addWindowListener(new WindowAdapter() { 
          public void windowClosing(WindowEvent e){ 
                System.exit(0); } });
	}
}
