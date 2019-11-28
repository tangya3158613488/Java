package exercise11_28;

import java.awt.*;
import java.awt.event.*;
class RadioButton extends Frame{
	private String city[]={"北京","上海","西安","重庆","深圳","大连"};
	private Checkbox radio[] = new Checkbox[6];
	private CheckboxGroup c=new CheckboxGroup();
	public  RadioButton()
	{  setLayout(new FlowLayout());
	add(new Label("这是一个单选按钮的例子"));
        add(new Label("请选择中国最大的城市: "));
	for(int i=0;i<6;i++){
		radio[i]=new Checkbox(city[i],c,false);
		add(radio[i]);
		}
	
         setSize(300,300);
	 setVisible(true);	
	 addWindowListener(new WindowAdapter() { 
          public void windowClosing(WindowEvent e){ 
                System.exit(0); } });
}
}
public class Example2
{   public static void main(String args[])
      {RadioButton win=new RadioButton();
      }
}