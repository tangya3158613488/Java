package exercise11_26;

import java.awt.*;
import java.awt.event.*;
class WinCard extends Frame implements ActionListener
{  
	CardLayout mycard;
   Button buttonFirst,buttonLast,buttonNext;
   Panel pCenter; 
   WinCard() 
   {  mycard=new CardLayout();
      pCenter=new Panel();
      pCenter.setLayout(mycard);      
      buttonFirst=new Button("first");
      buttonLast=new Button("last");
      buttonNext=new Button("next"); 
       for(int i=1;i<=20;i++) 
         {  pCenter.add("i am"+i,new Button("I am the "+i+" button")); 
         }
      buttonFirst.addActionListener(this);
      buttonLast.addActionListener(this);
      buttonNext.addActionListener(this);
      Panel pSouth=new Panel();
      pSouth.add(buttonFirst);
      pSouth.add(buttonNext);
      pSouth.add(buttonLast);
      add(pCenter,BorderLayout.CENTER);
      add(pSouth,BorderLayout.SOUTH);
      setBounds(10,10,200,190);
      setVisible(true);
       addWindowListener(new WindowAdapter() { 
          public void windowClosing(WindowEvent e){ 
                System.exit(0); } });
   }
   public void actionPerformed(ActionEvent e)
   {  if(e.getSource()==buttonFirst)
        {  mycard.first(pCenter);
        }
      else if(e.getSource()==buttonNext)
       {   mycard.next(pCenter);
       }
      else if(e.getSource()==buttonLast)
       {   mycard.last(pCenter);
       }
   }
}
public class Example11
{  public static void main(String args[])
   { new WinCard();
   }
}
