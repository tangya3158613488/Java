import java.awt.*;
import java.awt.event.*;
class MyWindow extends Frame implements ActionListener
{ TextField text1,text2,text3; 
  MyWindow()
   {  setLayout(new FlowLayout());
      text1=new TextField(8);
      text2=new TextField(8);
      text3=new TextField(15);
      add(text1);
      add(text2);
      add(text3);
      text1.addActionListener(this); 
      text2.addActionListener(this);
      setBounds(100,100,150,150);
      setVisible(true);
      validate();
   }  
   public void actionPerformed(ActionEvent e) 
   {  if(e.getSource()==text1) 
      {  String word=text1.getText();
         if(word.equals("boy")) 
           { text3.setText("�к�");
           }
         else if (word.equals("girl")) 
           { text3.setText("Ů��");
           }
         else if (word.equals("sun")) 
          {  text3.setText("̫��");
          }
        else 
          {  text3.setText("û�иõ���");
          }
      }
    else if(e.getSource()==text2) 
      {  String word=text2.getText();
         if(word.equals("�к�")) 
         {  text3.setText("boy");
         }
         else if (word.equals("Ů��"))
          { text3.setText("girl");
          }
        else if (word.equals("̫��")) 
         {  text3.setText("sun");
         }
       else
        {   text3.setText("û�иõ���");
        }
      }
   }
}
public class Example8_2_2
{   public static void main(String args[])
    {  MyWindow win=new MyWindow();
    }
}