//����13.3�� �б�����ѡ���������ƶ���

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class MultiSelectJFrame extends JFrame implements FilenameFilter, ActionListener
{
    private JList list_source; 
    private DefaultListModel listModel_dest;                    //Ĭ���б��ģ����
    
    public MultiSelectJFrame()
    {
        super("�б�����ѡ���������ƶ�"); 
        Dimension dim=getToolkit().getScreenSize();
        this.setBounds(dim.width/4,dim.height/4,dim.width/2,dim.height/2);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new GridLayout(1,3));
        
        String[] filenames = new File("����","").list(this);  //��õ�ǰĿ¼��ָ����Ŀ¼���ļ����б�
        for (int i=0; i<filenames.length; i++)
        {      
            int index=filenames[i].lastIndexOf(".gif");
            filenames[i]=filenames[i].substring(0,index);        //����ļ�����ȥ���ļ���չ��
        }
        list_source = new JList(filenames); 
        this.getContentPane().add(new JScrollPane(list_source));
        list_source.setCellRenderer(new CheckBoxListCellRenderer()); //�����Զ���ĵ�Ԫ��Ⱦ��
        
//        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
//        JPanel panel = new JPanel(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
        Box panel = new Box(BoxLayout.LINE_AXIS);
//        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.getContentPane().add(panel);
        JButton button_move = new JButton("��");
        button_move.addActionListener(this);
        panel.add(button_move);

        this.listModel_dest = new DefaultListModel();      //Ĭ���б��ģʽ
        JList list_dest = new JList(listModel_dest);       //�����б��
        this.getContentPane().add(list_dest);
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
        Object[] items=this.list_source.getSelectedValues();//����б������ѡ��������
        for (int i=0; i<items.length; i++)
            this.listModel_dest.addElement(items[i]);      //�б��ģ�����������
    }
    
    public static void main(String arg[])
    {
        new MultiSelectJFrame();
    }
}