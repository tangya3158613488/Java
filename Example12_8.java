import java.awt.*;
import java.awt.event.*;
public class Example8_20
{  public static void main(String args[])
   {  FWindow f=new FWindow("����"); 
   }
}
class  FWindow extends Frame implements ActionListener
{  FileDialog filedialog_save, filedialog_load;//����2���ļ��Ի���
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
      menu=new Menu("�ļ�"); 
      itemSave=new MenuItem("�����ļ�"); 
      itemLoad=new MenuItem("���ļ�"); 
      itemSave.addActionListener(this); 
      itemLoad.addActionListener(this);
      menu.add(itemSave);
      menu.add(itemLoad); 
      menubar.add(menu);
      setMenuBar(menubar);
      filedialog_save=new FileDialog(this,"�����ļ�����",FileDialog.SAVE);
      filedialog_save.setVisible(false);
      filedialog_load=new FileDialog(this,"���ļ�����",FileDialog.LOAD);
      filedialog_load.setVisible(false);
      filedialog_save.addWindowListener(new WindowAdapter()//�Ի�������������
              {  public void windowClosing(WindowEvent e)
                   {  filedialog_save.setVisible(false);
                   }
              });
      filedialog_load.addWindowListener(new WindowAdapter()//�Ի�������������
             {public void windowClosing(WindowEvent e)
                   { filedialog_load.setVisible(false);
                   }
             });
      addWindowListener(new WindowAdapter()  //��������������
            {
               public void windowClosing(WindowEvent e)
                  { setVisible(false);System.exit(0);
                  }
            });
   }
   public void actionPerformed(ActionEvent e) //ʵ�ֽӿ��еķ���
   {  if(e.getSource()==itemSave)
         {  filedialog_save.setVisible(true);
            String name=filedialog_save.getFile();
            if(name!=null)
              {  text.setText("��ѡ���˱����ļ�,������"+name);
              }      
            else
              {   text.setText("û�б����ļ�");
              }
         }
       else if(e.getSource()==itemLoad)
        {  filedialog_load.setVisible(true);
            String name=filedialog_load.getFile();
           if(name!=null)
             {  text.setText("��ѡ���˴��ļ�,������"+name);
             }      
           else
            {   text.setText("û�д��ļ�");
            }
        }
   }
}

