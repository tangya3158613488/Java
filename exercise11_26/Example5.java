package exercise11_26;

import java.awt.*;
import java.awt.event.*;
class WindowTextArea extends Frame 
{   
	TextArea text1;
     WindowTextArea() 
    { 
      setLayout(new FlowLayout());
      text1=new TextArea(6,15);
      add(text1);
      setBounds(100,100,350,160);
      setVisible(true);
      addWindowListener(new WindowAdapter() { 
          public void windowClosing(WindowEvent e){ 
                System.exit(0); } });}  
    }

public class Example5
{   public static void main(String args[])
    { WindowTextArea win=new WindowTextArea();
    }
} 
