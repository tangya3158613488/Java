package exercise11_26;
import java.awt.*;
import java.awt.event.*;
public class Example7
{
	public static void main(String[] args) 
	{      
		Frame frm=new Frame("我创建的一个窗口");
	  	Button btn=new Button("确定");
		frm.setSize(300,250);
		frm.setLocation(100,100);
		frm.setBackground(Color.orange);
		frm.setLayout(null);   
		btn.setBounds(100,100,100,40);   //setLayout与setBounds()一起使用
		frm.add(btn);
		frm.setVisible(true);
		frm. addWindowListener(new WindowAdapter() { 
          public void windowClosing(WindowEvent e){ 
                System.exit(0); } });
	}
}

