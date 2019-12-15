package exercise11_28;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

 class MyCalculator extends Frame{
    
    private JTextField text; //�����ı���
    JPanel panel = new JPanel();
    JButton jb0,jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9;
    JButton bot,add,sub,mul,div,equ;
    public MyCalculator() {
    	this.setTitle("�ҵļ�����");
        text = new JTextField(30);
        //��text���뱾JFrame�У�����Ϊ�߽粼�֣�λ��Ϊnorth
        this.add(text, BorderLayout.NORTH);
        
        //�������ְ�ť
        jb0=new JButton("0");
        jb1=new JButton("1");
        jb2=new JButton("2");
        jb3=new JButton("3");
        jb4=new JButton("4");
        jb5=new JButton("5");
        jb6=new JButton("6");
        jb7=new JButton("7");
        jb8=new JButton("8");
        jb9=new JButton("9");
        //�������Ű�ť
        bot=new JButton(".");
        add=new JButton("+");
        sub=new JButton("-");
        mul=new JButton("*");
        div=new JButton("/");
        
       panel=new JPanel();
       panel.setLayout(new GridLayout(4,4));
       
       //��һ��
       panel.add(jb7);
       panel.add(jb8);
       panel.add(jb9);
       panel.add(div);
       //�ڶ���
       panel.add(jb4);
       panel.add(jb5);
       panel.add(jb6);
       panel.add(mul);
       //������
       panel.add(jb1);
       panel.add(jb2);
       panel.add(jb3);
       panel.add(sub);
       //������
       panel.add(bot);
       panel.add(jb0);
       panel.add(equ);
       panel.add(add);
       
       add(panel);
       
	    this.setBounds(400, 200, 500, 300);
	    this.setVisible(true);
        addWindowListener(new WindowAdapter() { 
            public void windowClosing(WindowEvent e){ 
             System.exit(0);} });   
  }
 
	  //����Ⱥ��¼�
	  /*JButton equ = new JButton(name[name.length]);	
	  equ.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			text.setText(text.getText()+equ.getText());
			if(text.getText().contains("+")){
				StringTokenizer st1=new StringTokenizer(text.getText(),"+");
				double d1,d2=0;
				d1=Double.parseDouble(st1.nextToken());
				while(st1.hasMoreTokens()){
					StringTokenizer st2=new StringTokenizer(st1.nextToken(),"=");
					d2=Double.parseDouble(st2.nextToken());
				}
				text.setText(text.getText()+" "+(d1+d2));
			}
			
		}
	});
		
	}
 
//����ť���¼�������
private void Text(JButton button) {
	button.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String str=button.getText();
			text.setText(text.getText()+str);
			
		}
	});
}*/
}
public class Calulator{
	public static void main(String[] args) {
		MyCalculator c=new MyCalculator();
	}
}

