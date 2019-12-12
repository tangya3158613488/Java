//【例6.6】 银行贷款按月还本付息的计算。

import java.util.*;
import java.awt.event.*;
import javax.swing.*;

public class LoanJFrame extends JFrame implements ActionListener
{
    private JTextField text_money, text_rate, text_year;   //贷款金额、利率、年限文本行
    private JSpinner spin_year, spin_month;                //起始年月微调文本行
    private JButton button;                                //计算按钮
    private JTable table;                                  //表格
    
    public LoanJFrame()
    {
        super("银行贷款按月还本付息的计算");
        this.setBounds(300,240,740,400);
        this.setBackground(java.awt.Color.lightGray);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        this.getContentPane().add(panel, "North");
        panel.add(new JLabel("贷款金额"));
        text_money = new JTextField("100000",6);
        panel.add(text_money);
 
        panel.add(new JLabel("元    贷款利率"));
        text_rate = new JTextField("0.5025",6);
        panel.add(text_rate);
        panel.add(new JLabel("%/月    贷款年限"));
        text_year = new JTextField("5",3);
        panel.add(text_year);

        panel.add(new JLabel("年    起始年月"));
        Calendar today = Calendar.getInstance();           //获得当前日期
        int year=today.get(Calendar.YEAR);                 //当年
        int nextmonth=today.get(Calendar.MONTH)+1;         //get(Calendar.MONTH)范围是0~11
        nextmonth = nextmonth%12+1;                        //下月
        if (nextmonth==1)                                  //12月的下月是次年1月
            year++;
        spin_year = new JSpinner();
        spin_year.setValue(year);                          //设置值
        panel.add(spin_year);
        panel.add(new JLabel("年"));
        spin_month=new JSpinner(new SpinnerNumberModel(nextmonth, 1, 12, 1));
                                                           //数值模式初值为下月，范围是1~12，变化值为1
        panel.add(spin_month);
        panel.add(new JLabel("月"));
        button = new JButton("计算");
        panel.add(button);
        button.addActionListener(this);
        actionPerformed(null);                             //执行单击事件处理方法
        this.getContentPane().add(new JScrollPane(table)); //滚动窗格（包含表格）添加到框架内容窗格中部
        this.setVisible(true);
    }
     
    public void actionPerformed(ActionEvent e)             //单击事件处理方法
    {
        String titles[]={"年月","本金余额（元）","月还本金（元）","月还利息（元）","月还本息（元）"};
        int months=Integer.parseInt(text_year.getText())*12;   //还款月数
        Object datas[][]=new Object[months][5];                //创建存储表格数据项的二维数组
        int year=Integer.parseInt(""+spin_year.getValue());    //起始年份
        int mon=Integer.parseInt(""+spin_month.getValue());    //起始月份
        double leavings=Double.parseDouble(""+text_money.getText()); //本金余额
        double pay=leavings/months;                            //月还本金
        double rate=Double.parseDouble(""+text_rate.getText());//贷款利率
        for (int i=0; i<months; i++)
        {
            datas[i][0] = year+"年"+mon+"月";
            datas[i][1] = String.format("%9.2f",leavings);
            datas[i][2] = String.format("%9.2f",pay);               //月还本金
            datas[i][3] = String.format("%9.2f",leavings*rate);     //月还利息
            datas[i][4] = String.format("%9.2f",pay+leavings*rate); //月还本息
            if (mon==12)
                year++;
            mon = mon%12+1;                                //下月
            leavings -= pay;                               //本金余额减去月还本金
        }
        table=new JTable(datas, titles);                   //创建表格，datas指定数据，titles指定列标题
    }
    
    public static void main(String arg[])
    {
        new LoanJFrame();
    }
}

