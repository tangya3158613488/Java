package exercise11_19;
import java.awt.*;
import java.awt.event.*;

class FirstWindow extends Frame{
	MenuBar menubar;
	Menu menu1,menu2,menu3;
	MenuItem item1,item2,item3,item4,item5,item6;
	public FirstWindow(String s) {
		setTitle(s);
		menubar=new MenuBar();
		menu1=new Menu("文件");
		menu2=new Menu("编辑");
		menu3=new Menu("查看");
		item1=new MenuItem("打开");
		
		item2=new CheckboxMenuItem("保存");
		
		MenuShortcut ms1=new MenuShortcut(KeyEvent.VK_E);
		MenuShortcut ms2=new MenuShortcut(KeyEvent.VK_C);
		MenuShortcut ms3=new MenuShortcut(KeyEvent.VK_V);
		item3=new MenuItem("关闭",ms1);
		item4=new MenuItem("粘贴",ms3);
		item5=new MenuItem("复制",ms2);
		item6=new MenuItem("状态");
		
		menu1.add(item1);
		menu1.add(item2);
		menu1.add(item3);
		menu1.addSeparator();
		
		menu2.add(item4);
		menu2.add(item5);
		
		menu3.add(item6);
		
		menubar.add(menu1);
		menubar.add(menu2);
		menubar.add(menu3);
		setMenuBar(menubar);
		setSize(300,250);
		setLocation(100,100);
		setVisible(true);
		addWindowListener(new WindowAdapter() { 
            public void windowClosing(WindowEvent e){ 
             System.exit(0);     } });    
	}
}
public class Test2 {
	public static void main(String[] args) {
		FirstWindow win=new FirstWindow("一个带菜单的窗口");
	}
}
