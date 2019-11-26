package exercise11_26;

import java.awt.*;
import java.awt.event.*;
class WindowFlow extends Frame 
{ 
	WindowFlow(String s) 
    { super(s);
      FlowLayout flow=new FlowLayout();
      flow.setAlignment(FlowLayout.LEFT);
      flow.setHgap(4);
      flow.setVgap(8);
      setLayout(flow);
      for(int i=1;i<=10;i++) 
         { Button b=new Button("I am "+i);
           add(b);
         }
      setBounds(100,100,150,120);
      setVisible(true);
      addWindowListener(new WindowAdapter() { 
          public void windowClosing(WindowEvent e){ 
                System.exit(0); } });
 }
}
public class Example9
{   public static void main(String args[])
    { WindowFlow win=new WindowFlow("FlowLayout布局窗口");
    }
}
