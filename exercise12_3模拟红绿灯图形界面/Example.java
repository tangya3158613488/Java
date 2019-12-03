package exercise12_3;

import java.awt.*;
import java.awt.event.*;
class MyButton extends Button implements ActionListener
{  int x=10,y=10,i=0; 
   Color color[]={Color.red,Color.yellow,Color.green};
   Color c=color[0];
      MyButton()
     {setSize(38,85); 
      setBackground(Color.cyan);
      addActionListener(this);
     }
   public void paint(Graphics g)
     {g.setColor(c);
      g.fillOval(x,y,20,20);       
     }
  public void update(Graphics g)
     {g.clearRect(x,y,20,20);
      paint(g);
     }
  public void actionPerformed(ActionEvent e)
   { i=(i+1)%3;
     c=color[i];
     y=y+23;
     if(y>56)
       y=10;  
     repaint();
   }
}
class WindowCanvas extends Frame
 {    WindowCanvas()
        { MyButton button=new MyButton();
          setLayout(null);
          add(button);
          button.setLocation(30,30);
          setBounds(60,125,100,200);
          setVisible(true);
          validate();
       }
}
public class Example
{  public static void main(String args[])
   {  new WindowCanvas(); 
    }
}
