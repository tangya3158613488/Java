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
		menu1=new Menu("�ļ�");
		menu2=new Menu("�༭");
		menu3=new Menu("�鿴");
		item1=new MenuItem("��");
		
		item2=new CheckboxMenuItem("����");
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
		MenuShortcut ms1=new MenuShortcut(KeyEvent.VK_E);
		MenuShortcut ms2=new MenuShortcut(KeyEvent.VK_C);
		MenuShortcut ms3=new MenuShortcut(KeyEvent.VK_V);
		item3=new MenuItem("�ر�",ms1);
		item4=new MenuItem("ճ��",ms3);
		item5=new MenuItem("��ֵ",ms2);
		item6=new MenuItem("״̬");
		
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
		menu4=new Menu("����");
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
               {  ta.setText("��ѡ���˱����ļ�,������"+name);
               }      
             else
               {   ta.setText("û�б����ļ�");
               }
          }
        else if(e.getSource()==item1)
         {  filedialog_load.setVisible(true);
             String name=filedialog_load.getFile();
            if(name!=null)
              {  ta.setText("��ѡ���˴��ļ�,������"+name);
              }      
            else
             {   ta.setText("û�д��ļ�");
             }
         }
    }
}
    public class MyText{
    	public static void main(String[] args) {
    		WindowTest wt=new WindowTest("�ҵļ��±�");
		}
    }

