package exercise11_29;

import java.awt.event.*;
import java.awt.*;
import javax.swing.JOptionPane;
class Dwindow extends Frame implements ActionListener
{  TextField inputName;
   TextArea  save;
   Dwindow(String s)
   {  super(s);
      inputName=new TextField(22);
      inputName.addActionListener(this);
      save=new TextArea();
      add(inputName,BorderLayout.NORTH); 
      add(save,BorderLayout.CENTER); 
      setBounds(60,60,300,300);
      setVisible(true);
      validate();
      addWindowListener(new WindowAdapter()
                      {   public void windowClosing(WindowEvent e)
                           { System.exit(0);
                           }
                      }
                   );
   }
   public void actionPerformed(ActionEvent e) 
   {  String s=inputName.getText();
      int n=JOptionPane.showConfirmDialog(this,"确认正确吗???","确认对话框",        JOptionPane.YES_NO_OPTION );
      if(n==JOptionPane.YES_OPTION)  
        {  save.append("\n"+s);
        }  
      else if(n==JOptionPane.NO_OPTION)  
       { inputName.setText(null);
       }  
   }
}
public class Example2
{  public static void main(String args[]) 
   {  new Dwindow("带对话框的窗口");
   }
}