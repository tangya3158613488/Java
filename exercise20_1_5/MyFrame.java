package exercise20_1_5;

import java.awt.*;
import java.awt.event.*;
public  class MyFrame extends Frame implements ActionListener{
	public MyFrame(){
		Button btn = new Button("Exit");
		setLayout(new FlowLayout());
		add(btn);
		btn.addActionListener(this);
		setSize(400,300);
		setVisible(true);
	}
	public static void main(String[] args)
	{
		MyFrame fr = new MyFrame();
	}

	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

}