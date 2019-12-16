//����12.4�� �б�����ѡ���������ƶ���

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class MultiSelectJFrame extends JFrame implements FilenameFilter, ActionListener
{
    private JList list_source; 
    private DefaultListModel listModel_source, listModel_dest; //Ĭ���б��ģ����
    
    public MultiSelectJFrame()
    {
        super("�б�����ѡ���������ƶ�"); 
        this.setBounds(200,200,400,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(),BoxLayout.X_AXIS));//.LINE_AXIS));
                                                           //��ʽˮƽ����
        this.listModel_source = new DefaultListModel();    //Ĭ���б��ģʽ
        String[] filenames=new File("����","").list(this); //��õ�ǰĿ¼��ָ����Ŀ¼���ļ����б�
        for (int i=0; i<filenames.length; i++)
        {      
            int index=filenames[i].lastIndexOf(".gif");
            this.listModel_source.addElement(filenames[i].substring(0,index));
                                                           //���ļ������������ļ���չ������ӵ��б��ģʽ
        }
        list_source = new JList(this.listModel_source);    //�����б��ָ���б��ģʽ
        this.getContentPane().add(new JScrollPane(list_source));
        list_source.setCellRenderer(new CheckBoxListCellRenderer()); //�����Զ���ĵ�Ԫ��Ⱦ��
        
        Box box = new Box(BoxLayout.Y_AXIS);               //Box�����Ժ�ʽ��ֱ���� 
        this.getContentPane().add(box);
        JButton button1 = new JButton("����");
        button1.addActionListener(this);
        box.add(button1);
        JButton button2 = new JButton("����");
        button2.addActionListener(this);
        box.add(button2);

        this.listModel_dest = new DefaultListModel();
        JList list_dest = new JList(listModel_dest);             //�����б��
        this.getContentPane().add(new JScrollPane(list_dest));
        this.setVisible(true);
    }

    class CheckBoxListCellRenderer extends JCheckBox implements ListCellRenderer
    {                                                      //�б��Ԫ��Ⱦ�����������ڲ���
        public Component getListCellRendererComponent(JList list,Object value,int index,boolean isSelected,boolean cellHasFocus)
        {
            setText(value.toString());
            setBackground(isSelected ? Color.lightGray : Color.white);  //ѡ���������ǳ��ɫ
            setForeground(isSelected ? Color.red : Color.black);        //ѡ���������ɫ��ʾ
//            setSelected(isSelected);                                    //��ǰ������ѡ��״̬
            setIcon(new ImageIcon(".\\����\\"+value.toString()+".gif")); //���ͼ��
            return this;
        }
    }
    
    public boolean accept(File dir, String filename)       //�ļ����˷�����ʵ���ļ��������ӿ�
    {
        return filename.toLowerCase().endsWith(".gif");    //�ļ���չ��ƥ��
    }    
    
    public void actionPerformed(ActionEvent e)             //�����¼���������������ť
    {
        if (e.getActionCommand()=="����")
        {
            Object[] items=this.list_source.getSelectedValues();//����б������ѡ��������
            for (int i=0; i<items.length; i++)
                this.listModel_dest.addElement(items[i]);  //�б��ģ�����������
        }
        else                                               //����"����"��ť
        {
            this.listModel_dest.removeAllElements();       //ɾ������������
            int count=listModel_source.getSize();          //����б�����������
            for (int i=0; i<count; i++)
                this.listModel_dest.addElement(listModel_source.elementAt(i));
        }
    }
    
    public static void main(String arg[])
    {
        new MultiSelectJFrame();
    }
}