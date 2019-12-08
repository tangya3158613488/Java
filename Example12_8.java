import java.awt.*;
import java.awt.event.*;
public class Example8_20
{  public static void main(String args[])
   {  FWindow f=new FWindow("窗口"); 
   }
}
class  FWindow extends Frame implements ActionListener
{  FileDialog filedialog_save, filedialog_load;//声明2个文件对话框
   MenuBar menubar;
   Menu menu;
   MenuItem itemSave,itemLoad;
   TextArea text;
   FWindow(String s)
   {  super(s); 
      setSize(300,400);
      setVisible(true); 
      text=new TextArea(10,10);
      add(text,"Center"); 
      validate(); 
      menubar=new MenuBar();
      menu=new Menu("文件"); 
      itemSave=new MenuItem("保存文件"); 
      itemLoad=new MenuItem("打开文件"); 
      itemSave.addActionListener(this); 
      itemLoad.addActionListener(this);
      menu.add(itemSave);
      menu.add(itemLoad); 
      menubar.add(menu);
      setMenuBar(menubar);
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
   }
   public void actionPerformed(ActionEvent e) //实现接口中的方法
   {  if(e.getSource()==itemSave)
         {  filedialog_save.setVisible(true);
            String name=filedialog_save.getFile();
            if(name!=null)
              {  text.setText("你选择了保存文件,名字是"+name);
              }      
            else
              {   text.setText("没有保存文件");
              }
         }
       else if(e.getSource()==itemLoad)
        {  filedialog_load.setVisible(true);
            String name=filedialog_load.getFile();
           if(name!=null)
             {  text.setText("你选择了打开文件,名字是"+name);
             }      
           else
            {   text.setText("没有打开文件");
            }
        }
   }
}

