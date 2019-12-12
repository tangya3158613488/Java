//����6.6�� ���д���»�����Ϣ�ļ��㡣

import java.util.*;
import java.awt.event.*;
import javax.swing.*;

public class LoanJFrame extends JFrame implements ActionListener
{
    private JTextField text_money, text_rate, text_year;   //��������ʡ������ı���
    private JSpinner spin_year, spin_month;                //��ʼ����΢���ı���
    private JButton button;                                //���㰴ť
    private JTable table;                                  //���
    
    public LoanJFrame()
    {
        super("���д���»�����Ϣ�ļ���");
        this.setBounds(300,240,740,400);
        this.setBackground(java.awt.Color.lightGray);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        this.getContentPane().add(panel, "North");
        panel.add(new JLabel("������"));
        text_money = new JTextField("100000",6);
        panel.add(text_money);
 
        panel.add(new JLabel("Ԫ    ��������"));
        text_rate = new JTextField("0.5025",6);
        panel.add(text_rate);
        panel.add(new JLabel("%/��    ��������"));
        text_year = new JTextField("5",3);
        panel.add(text_year);

        panel.add(new JLabel("��    ��ʼ����"));
        Calendar today = Calendar.getInstance();           //��õ�ǰ����
        int year=today.get(Calendar.YEAR);                 //����
        int nextmonth=today.get(Calendar.MONTH)+1;         //get(Calendar.MONTH)��Χ��0~11
        nextmonth = nextmonth%12+1;                        //����
        if (nextmonth==1)                                  //12�µ������Ǵ���1��
            year++;
        spin_year = new JSpinner();
        spin_year.setValue(year);                          //����ֵ
        panel.add(spin_year);
        panel.add(new JLabel("��"));
        spin_month=new JSpinner(new SpinnerNumberModel(nextmonth, 1, 12, 1));
                                                           //��ֵģʽ��ֵΪ���£���Χ��1~12���仯ֵΪ1
        panel.add(spin_month);
        panel.add(new JLabel("��"));
        button = new JButton("����");
        panel.add(button);
        button.addActionListener(this);
        actionPerformed(null);                             //ִ�е����¼�������
        this.getContentPane().add(new JScrollPane(table)); //�������񣨰��������ӵ�������ݴ����в�
        this.setVisible(true);
    }
     
    public void actionPerformed(ActionEvent e)             //�����¼�������
    {
        String titles[]={"����","������Ԫ��","�»�����Ԫ��","�»���Ϣ��Ԫ��","�»���Ϣ��Ԫ��"};
        int months=Integer.parseInt(text_year.getText())*12;   //��������
        Object datas[][]=new Object[months][5];                //�����洢���������Ķ�ά����
        int year=Integer.parseInt(""+spin_year.getValue());    //��ʼ���
        int mon=Integer.parseInt(""+spin_month.getValue());    //��ʼ�·�
        double leavings=Double.parseDouble(""+text_money.getText()); //�������
        double pay=leavings/months;                            //�»�����
        double rate=Double.parseDouble(""+text_rate.getText());//��������
        for (int i=0; i<months; i++)
        {
            datas[i][0] = year+"��"+mon+"��";
            datas[i][1] = String.format("%9.2f",leavings);
            datas[i][2] = String.format("%9.2f",pay);               //�»�����
            datas[i][3] = String.format("%9.2f",leavings*rate);     //�»���Ϣ
            datas[i][4] = String.format("%9.2f",pay+leavings*rate); //�»���Ϣ
            if (mon==12)
                year++;
            mon = mon%12+1;                                //����
            leavings -= pay;                               //��������ȥ�»�����
        }
        table=new JTable(datas, titles);                   //�������datasָ�����ݣ�titlesָ���б���
    }
    
    public static void main(String arg[])
    {
        new LoanJFrame();
    }
}

