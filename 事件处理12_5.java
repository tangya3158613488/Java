import java.awt.*;
import java.awt.event.*;
class MyFrame extends Frame 
implements WindowListener
{   TextArea text;
MyFrame()
{ setBounds(100,100,200,300);
      setVisible(true);
      text=new TextArea();
      add(text,BorderLayout.CENTER); 
      addWindowListener(this);
      validate();
    } 
public void windowActivated(WindowEvent e)
{ text.append("\n�ұ�����");
      validate();
    }
public void windowDeactivated(WindowEvent e)
{  text.append("\n�Ҳ��Ǽ���״̬��");
       setBounds(0,0,400,400); 
       validate();
    }
public void windowClosing(WindowEvent e) 
{ text.append("\n�������ڹر���");
      dispose();
    }
public void windowClosed(WindowEvent e)
{  System.out.println("�����������"); 
       System.exit(0);
    }
public void windowIconified(WindowEvent e)
{  text.append("\n��ͼ�껯��");
    }
public void windowDeiconified(WindowEvent e)
{ text.append("\n�ҳ���ͼ�껯"); 
      setBounds(0,0,400,400);
      validate();
    }
    public void windowOpened(WindowEvent e){}
}
public class Example8_2_8
{  public static void main(String args[])
{  new MyFrame();
    }
}

