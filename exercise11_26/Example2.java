package exercise11_26;

import java.awt.*;
import java.awt.event.*;
public class Example2
{
	public static void main(String[] args) 
	{   
		Frame frm=new Frame("我创建的一个窗口");
		Toolkit tool=frm.getToolkit(); 
        Dimension dim=tool.getScreenSize();
        frm.setBounds(0,0,dim.width,dim.height/2);
        frm.setBackground(Color.blue);
		frm.setVisible(true);
		frm.addWindowListener(new WindowAdapter() { 
        public void windowClosing(WindowEvent e){ 
                System.exit(0); } });
	}
}