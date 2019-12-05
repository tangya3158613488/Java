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
{ text.append("\n我被激活");
      validate();
    }
public void windowDeactivated(WindowEvent e)
{  text.append("\n我不是激活状态了");
       setBounds(0,0,400,400); 
       validate();
    }
public void windowClosing(WindowEvent e) 
{ text.append("\n窗口正在关闭呢");
      dispose();
    }
public void windowClosed(WindowEvent e)
{  System.out.println("程序结束运行"); 
       System.exit(0);
    }
public void windowIconified(WindowEvent e)
{  text.append("\n我图标化了");
    }
public void windowDeiconified(WindowEvent e)
{ text.append("\n我撤消图标化"); 
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

