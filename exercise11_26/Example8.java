package exercise11_26;

import java.awt.*;
import java.awt.event.*;
public class Example8
 {
    static Frame frm=new Frame("Panel class"); // 创建窗口frm
    static Panel pnl=new Panel(new GridLayout(3,3)); // 创建面板   
    static Label lab=new Label("0. ",Label.RIGHT);  // 创建标签lab
     public static void main(String args[])
      {
	        frm.setLayout(null);    // 取消窗口的版面设置
	        frm.setLocation(100,100);
	        frm.setSize(200,150); 
	        frm.setResizable(false);   // 将窗口设置为固定大小
	        lab.setBounds(20,30,120,20);
	        lab.setBackground(new Color(240,220,190));  // 设置标签的颜色
	        pnl.setBounds(20,60,120,80);   // 设置pnl置于窗口内的位置
	        for(int i=1;i<=9;i++)
	          pnl.add(new Button(Integer.toString(i)));  // 加入按钮
	          
	        frm.add(lab);   // 将lab放进窗口中
	        frm.add(pnl);   // 将面板放进窗口中
	        frm.setVisible(true); 
	        frm.addWindowListener(new WindowAdapter() { 
	          public void windowClosing(WindowEvent e){ 
	                System.exit(0); } });}
  }

