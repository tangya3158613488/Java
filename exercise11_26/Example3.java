package exercise11_26;

import java.awt.*;
import java.awt.event.*;
class FirstWindow extends Frame  
{   MenuBar menubar;
    Menu menu;
    MenuItem  item1,item2,item3;
    FirstWindow(String s) 
    { setTitle(s); 
     //Toolkit tool=getToolkit(); 
     //Dimension dim=tool.getScreenSize();
     //setBounds(0,0,dim.width,dim.height/2);
      menubar=new MenuBar(); 
      menu=new Menu("文件");
     item1=new MenuItem("打开");
       
     // item2=new CheckboxMenuItem("保存"); //添加复选框菜单项
      item2=new MenuItem("保存");
      item3=new MenuItem("关闭");
      //MenuShortcut ms = new MenuShortcut(KeyEvent.VK_E);      
     // item3=new MenuItem("关闭",ms); //添加快捷键

     
      menu.add(item1);
      menu.add(item2);
     // menu.addSeparator();
      menu.add(item3);
      menubar.add(menu);
      setMenuBar(menubar); 
      setSize(300,250);
      setLocation(100,100);
      setVisible(true);               
    addWindowListener(new WindowAdapter() { 
          public void windowClosing(WindowEvent e){ 
                System.exit(0); } });}  
}
public class Example3
{   public static void main(String args[])
    {  FirstWindow win=new FirstWindow("一个带菜单的窗口"); 
         
	}
} 
