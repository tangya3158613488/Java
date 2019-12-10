package com.bbm.staticview;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;


/*图书借阅管理-》图书借阅*/
public class BookBorrow extends JFrame {	
	private static final long serialVersionUID = 1L;
	
	private JPanel selectJP,select_conditionJP,select_resultJP,borrowJP,buttonJP;
	private JTextField readeridJTF,readernameJTF,readertypeJTF,ISBNJTF,booknameJTF,authorJTF,printtimeJTF,publishJTF,publishdateJTF,unitpriceJTF,userJTF,booktypeJTF,borrowtimeJTF;
	private JLabel readeridJL,readernameJL,readertypeJL,ISBNJL,booknameJL,authorJL,categoryJL,printtimeJL,publishJL,publishdateJL,unitpriceJL,dateJL,userJL;
	private JTable jtable;	
	//private JFormattedTextField borrowdate;	
    private JScrollPane jscrollPane;
    private JButton borrowJB,closeJB;
    //private Users user = Login.getUser();
    
	public BookBorrow(){        
        setTitle("图书借阅");
        setBounds(100, 100, 600, 500);
                
        selectJP = new JPanel();        
        TitledBorder tb=new TitledBorder("读者借阅信息");
        selectJP.setBorder(tb);
        selectJP.setLayout(new BorderLayout());
        
        //查询条件面板
        select_conditionJP = new JPanel();
        readeridJL=new JLabel("读者编号：");
        select_conditionJP.add(readeridJL);
        readeridJTF = new JTextField();         
        readeridJTF.setColumns(10);
        select_conditionJP.add(readeridJTF);
        
        readernameJL=new JLabel("读者姓名：");
        select_conditionJP.add(readernameJL);
        readernameJTF = new JTextField();        
        readernameJTF.setColumns(10);
        select_conditionJP.add(readernameJTF);
        
        readertypeJL=new JLabel("读者类别：");
        select_conditionJP.add(readertypeJL);
        readertypeJTF = new JTextField();        
        readertypeJTF.setColumns(10);
        select_conditionJP.add(readertypeJTF);
        
        selectJP.add(select_conditionJP, BorderLayout.NORTH);
        //查询结果面板
        select_resultJP = new JPanel();
        jscrollPane = new JScrollPane();       
        jscrollPane.setViewportView(jtable);
        //显示边框
        jscrollPane.setPreferredSize(new Dimension(500, 140));
        //不显示边框        
        select_resultJP.add(jscrollPane);
        selectJP.add(select_resultJP,BorderLayout.CENTER);
        
        borrowJP = new JPanel();
        borrowJP.setBorder(new TitledBorder(null, "图书借阅", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
                
        //使用布局GridLayout
        final GridLayout gridLayout = new GridLayout(5, 4);
        gridLayout.setVgap(8);
        gridLayout.setHgap(8);
        borrowJP.setLayout(gridLayout);
        
        ISBNJL=new JLabel("ISBN：");
        ISBNJL.setHorizontalAlignment(SwingConstants.CENTER);
		borrowJP.add(ISBNJL);
		ISBNJTF=new JTextField();		
		ISBNJTF.setColumns(20);
		borrowJP.add(ISBNJTF);	
		
		categoryJL=new JLabel("类别：");
		categoryJL.setHorizontalAlignment(SwingConstants.CENTER);
		borrowJP.add(categoryJL);
		booktypeJTF=new JTextField();
		booktypeJTF.setColumns(20);        
		borrowJP.add(booktypeJTF);
		
		booknameJL=new JLabel("书名：");
		booknameJL.setHorizontalAlignment(SwingConstants.CENTER);
		borrowJP.add(booknameJL);
		booknameJTF=new JTextField();
		booknameJTF.setColumns(20);
		borrowJP.add(booknameJTF);
		
		authorJL=new JLabel("作者：");
		authorJL.setHorizontalAlignment(SwingConstants.CENTER);
		borrowJP.add(authorJL);
		authorJTF=new JTextField();
		authorJTF.setColumns(20);
		borrowJP.add(authorJTF);
		
		publishJL=new JLabel("出版社：");
		publishJL.setHorizontalAlignment(SwingConstants.CENTER);
		borrowJP.add(publishJL);
		publishJTF=new JTextField();
		borrowJP.add(publishJTF);		
		
		publishdateJL=new JLabel("出版日期：");
		publishdateJL.setHorizontalAlignment(SwingConstants.CENTER);
		borrowJP.add(publishdateJL);
		publishdateJTF=new JTextField();
		borrowJP.add(publishdateJTF);
		
		printtimeJL=new JLabel("印刷次数：");
		printtimeJL.setHorizontalAlignment(SwingConstants.CENTER);
		borrowJP.add(printtimeJL);
		printtimeJTF=new JTextField();
		borrowJP.add(printtimeJTF);
		
		unitpriceJL=new JLabel("单价：");
		unitpriceJL.setHorizontalAlignment(SwingConstants.CENTER);
		borrowJP.add(unitpriceJL);
		unitpriceJTF=new JTextField();
		borrowJP.add(unitpriceJTF);
		
		dateJL=new JLabel("当前日期：");
		dateJL.setHorizontalAlignment(SwingConstants.CENTER);
		borrowJP.add(dateJL);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String str = format.format(new java.util.Date());
		borrowtimeJTF=new JTextField();		
		borrowtimeJTF.setText(str);		
		borrowJP.add(borrowtimeJTF);
		
		userJL=new JLabel("操作人员：");
		userJL.setHorizontalAlignment(SwingConstants.CENTER);
		borrowJP.add(userJL);		
		userJTF=new JTextField();		
		//userJTF.setText(user.getName());
		userJTF.setColumns(20);
		userJTF.setEditable(false);
		borrowJP.add(userJTF);
		
		//按钮面板设计
		buttonJP=new JPanel();
		borrowJB=new JButton("借阅");		
		closeJB=new JButton("关闭");		
		buttonJP.add(borrowJB);
		buttonJP.add(closeJB);
				
		this.add(selectJP,BorderLayout.NORTH);
		this.add(borrowJP,BorderLayout.CENTER);
		this.add(buttonJP,BorderLayout.SOUTH);
               
        setVisible(true);
	}
	  
	 public static void main(String[] args) {
		new BookBorrow();
	}
}
