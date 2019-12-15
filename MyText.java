package exercise11_28;

import java.awt.*;
import java.awt.event.*;

class WindowTest extends Frame implements ActionListener{
	FileDialog filedialog_save, filedialog_load;
	MenuBar menubar;
	Menu menu1,menu2,menu3,menu4;
	MenuItem item1,item2,item3,item4,item5,item6;
	TextArea ta=new TextArea(10,10);
    public WindowTest(String s) {
		setTitle(s);
		menubar=new MenuBar();
		menu1=new Menu("文件");
		menu2=new Menu("编辑");
		menu3=new Menu("查看");
		item1=new MenuItem("打开");
		
		item2=new CheckboxMenuItem("保存");
		filedialog_save=new FileDialog(this,"保存文件话框",FileDialog.SAVE);
	    filedialog_save.setVisible(false);
	    filedialog_load=new FileDialog(this,"打开文件话框",FileDialog.LOAD);
	    filedialog_load.setVisible(false);
	    filedialog_save.addWindowListener(new WindowAdapter()//对话框增加适配器
	              {  public void windowClosing(WindowEvent e)
	                   {  filedialog_save.setVisible(false);
	                   }
	              });
	      filedialog_load.addWindowListener(new WindowAdapter()//对话框增加适配器
	             {public void windowClosing(WindowEvent e)
	                   { filedialog_load.setVisible(false);
	                   }
	             });
	      addWindowListener(new WindowAdapter()  //窗口增加适配器
	            {
	               public void windowClosing(WindowEvent e)
	                  { setVisible(false);System.exit(0);
	                  }
	            });
		MenuShortcut ms1=new MenuShortcut(KeyEvent.VK_E);
		MenuShortcut ms2=new MenuShortcut(KeyEvent.VK_C);
		MenuShortcut ms3=new MenuShortcut(KeyEvent.VK_V);
		item3=new MenuItem("关闭",ms1);
		item4=new MenuItem("粘贴",ms3);
		item5=new MenuItem("赋值",ms2);
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
		menu4=new Menu("帮助");
		menubar.setHelpMenu(menu4);
		add(ta);
		setSize(300,250);
		setLocation(100,100);
		setVisible(true);
    }
    public void actionPerformed(ActionEvent e) { 
    	if(e.getSource()==item2)
          {  filedialog_save.setVisible(true);
             String name=filedialog_save.getFile();
             if(name!=null)
               {  ta.setText("你选择了保存文件,名字是"+name);
               }      
             else
               {   ta.setText("没有保存文件");
               }
          }
        else if(e.getSource()==item1)
         {  filedialog_load.setVisible(true);
             String name=filedialog_load.getFile();
            if(name!=null)
              {  ta.setText("你选择了打开文件,名字是"+name);
              }      
            else
             {   ta.setText("没有打开文件");
             }
         }
    }
}
    public class MyText{
    	public static void main(String[] args) {
    		WindowTest wt=new WindowTest("我的记事本");
		}
    }

