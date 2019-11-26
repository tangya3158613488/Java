package exercise11_26;

import java.awt.*; 
import java.awt.event.*;
class Example10
{   public static void main(String args[])
    {  
	   Frame win=new Frame("窗体"); 
       win.setBounds(100,100,300,300);
       win.setVisible(true);
       Button bSouth=new Button("我在南边"),
              bNorth=new Button("我在北边"),
              bEast =new Button("我在东边"),
              bWest =new Button("我在西边");
       TextArea  bCenter=new TextArea("我在中心");
       win.add(bNorth,BorderLayout.NORTH);
       win.add(bSouth,BorderLayout.SOUTH);
       win.add(bEast,BorderLayout.EAST);
       win.add(bWest,BorderLayout.WEST); 
       win.add(bCenter,BorderLayout.CENTER);
       win.addWindowListener(new WindowAdapter() { 
          public void windowClosing(WindowEvent e){ 
                System.exit(0); } });  
    }
}

