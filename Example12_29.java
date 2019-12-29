import java.awt.*;
import java.awt.event.*;
class Mycanvas extends Canvas 
{  int x,y,r;
   Mycanvas() 
   {  setBackground(Color.cyan);
   }
   public void setX(int x)
   {  this.x=x; 
   }
   public void setY(int y)
   {  this.y=y;
   }
   public void setR(int r)
   {  this.r=r;
   }
   public void paint(Graphics g)
   {  g.drawOval(x,y,2*r,2*r);
   }
} 
class WindowCanvas extends Frame implements ActionListener
{  Mycanvas canvas;
   TextField inputR,inputX,inputY;
   Button b;
   WindowCanvas() 
   {  canvas=new Mycanvas();
      inputR=new TextField(5);
      inputX=new TextField(4);
      inputY=new TextField(4);
      Panel pNorth=new Panel(),
            pSouth=new Panel();
      pNorth.add(new Label("圆的位置坐标："));
      pNorth.add(inputX);
      pNorth.add(inputY);
      pSouth.add(new Label("圆的半径："));
      pSouth.add(inputR);
      b=new Button("确定");
      b.addActionListener(this);
      pSouth.add(b); 
      add(canvas,BorderLayout.CENTER);
      add(pNorth,BorderLayout.NORTH);
      add(pSouth,BorderLayout.SOUTH);
      setBounds(100,100,300,200);
      setVisible(true);
   } 
   public void actionPerformed(ActionEvent e)
   {  int x,y,r;
      try {  x=Integer.parseInt(inputX.getText());
             y=Integer.parseInt(inputY.getText());
             r=Integer.parseInt(inputR.getText());
             canvas.setX(x);
             canvas.setY(y);
             canvas.setR(r);
             canvas.repaint();
           }
      catch(NumberFormatException ee)
           { x=0;y=0;r=0;
           }
   }
}
public class Example8_27
{   public static void main(String args[])
    {  new WindowCanvas(); 
    }
}
