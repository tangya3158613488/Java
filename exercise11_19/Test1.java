package exercise11_19;
import java.awt.*;
import java.awt.event.*;
public class Test1 {
 public static void main(String[] args) {
	Frame frm=new Frame("创建新窗口");
	frm.setSize(300,150);
	frm.setLocation(100, 100);
	frm.setVisible(true);
	frm.addWindowListener(new WindowAdapter() { 
        public void windowClosing(WindowEvent e){ 
         System.exit(0);}});
}
}
