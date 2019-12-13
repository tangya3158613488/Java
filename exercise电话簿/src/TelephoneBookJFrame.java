//����12.5��  �绰����
//��	TelephoneBookJFrame��ʵ�ֵ绰���Ĵ洢�������ͼ���û����档

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.io.*;

public class TelephoneBookJFrame extends JFrame implements ListSelectionListener, ActionListener, WindowListener
{
    private String filename;                               //�ļ���
    private TreeSet<Friend> tbook;                         //�绰����ʹ��һ�������ϴ洢���Friend����
    private JList list;                                    //�б��
    private DefaultListModel listModel;                    //Ĭ���б��ģ��
    private JTable table;                                  //������
    private DefaultTableModel tableModel;                  //Ĭ�ϱ��ģ��
    private JComboBox combobox_name;                       //������Ͽ�
    private DefaultComboBoxModel comboModel;               //��Ͽ�ģ�ͣ�ѡ������
    private JTextField text_code;                          //�绰�����ı���

    public TelephoneBookJFrame(String filename)            //����ͼ���û�����
    {
        super("�绰��");
        this.setBounds(300,300,450,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addWindowListener(this);                      //ע�ᴰ���¼�������
        JSplitPane split_h=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT); //ˮƽ�ָ��
        split_h.setDividerLocation(40);                    //���ô�ֱ�ָ�����λ��
        this.getContentPane().add(split_h);
        JSplitPane split_v=new JSplitPane(JSplitPane.VERTICAL_SPLIT); //��ֱ�ָ��
        split_v.setDividerLocation(180);                   //����ˮƽ�ָ�����λ��

        this.filename = filename;
        tbook = new TreeSet<Friend>();
        this.readFromFile();                               //��ָ���ļ��ж�ȡ���ж�����Ϣ
        this.listModel = new DefaultListModel();           //Ĭ���б��ģ��
        this.listModel.addElement("ȫ��"); 
        this.list = new JList(listModel);                  //�����б��
        this.list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //���õ�ѡģʽ��Ĭ��Ϊ��ѡ
        this.list.addListSelectionListener(this);          //�б��ע��ѡ���¼�������
        split_h.add(new JScrollPane(this.list));           //����ڹ���������
        split_h.add(split_v);
        
        String[] columns={"����","�绰����"};               //�����е����ı���
        this.tableModel=new DefaultTableModel(columns,0);  //Ĭ�ϱ��ģ�ͣ�ָ���б��⣬0��
        this.table=new JTable(tableModel);                 //�����ձ�����б���
        this.list.setSelectedIndex(0);                     //ѡ���б���һ�ִ��valueChanged()����
        split_v.add(new JScrollPane(table));

        //������������Ͽ��ı��к���ӡ�ɾ�������ҵȰ�ť
        JPanel friendpanel=new JPanel(new GridLayout(2,1)); 
        split_v.add(friendpanel);
        JPanel panels[]={new JPanel(), new JPanel()};
        for (int i=0; i<panels.length; i++)
            friendpanel.add(panels[i]);
        panels[0].add(new JLabel(columns[0]));
        this.comboModel = new DefaultComboBoxModel();      //Ĭ����Ͽ�ģ��
        combobox_name = new JComboBox(this.comboModel); 
        combobox_name.setEditable(true);
        panels[0].add(combobox_name);
        panels[0].add(new JLabel(columns[1]));
        this.text_code = new JTextField("12345678901", 12);
        panels[0].add(text_code);
        this.getFamilyName();                              //�б�����Ͽ���ӵ绰���е���������
            
        String buttonstr[]={"���","ɾ��","���绰�������"};
        JButton buttons[] = new JButton[buttonstr.length];
        for (int i=0; i<buttons.length; i++)
        {
            buttons[i] = new JButton(buttonstr[i]);
            panels[1].add(buttons[i]);
            buttons[i].addActionListener(this);
        }
        this.setVisible(true);
    }

    public TelephoneBookJFrame()
    {
        this("friends.dat");                               //ָ��Ĭ���ļ���
    }
    
    private void readFromFile()                            //��ָ���ļ��ж�ȡ���ж���
    {
        try
        {
            FileInputStream fin=new FileInputStream(this.filename);  //�ļ��ֽ�������
            ObjectInputStream objin=new ObjectInputStream(fin);      //�����ֽ�������
            while (true)                                   //������δ����ʱ
                try
                {
                    tbook.add((Friend)objin.readObject()); //��ȡһ��������ӵ��绰��
                }
                catch (Exception e)                        //����ClassNotFoundException��EOFException�쳣 
                {
                    break;
                }
            objin.close();                                 //�ȹرն�����
            fin.close();                                   //�ٹر��ļ���
        }
        catch (IOException ioe){}                          //ָ���ļ�������ʱ�����Ϊ��
    }

    private void getFamilyName()                           //JList��ӵ绰���е���������
    {
        if (!tbook.isEmpty())
        {
            Iterator it=tbook.iterator();                  //����һ������������
            while (it.hasNext())                           //���к��Ԫ�أ�ʹ�õ�������������
            {
                Friend f=(Friend)it.next();                //���غ��Ԫ��
                String familyname=f.getName().charAt(0)+"";//�������
                if (!this.listModel.contains(familyname))
                {
                    this.listModel.addElement(familyname); //�б��ģ����Ӳ��ظ�������
                    this.comboModel.addElement(familyname); //��Ͽ�ģ����Ӳ��ظ�������
                }
            }
        }
    }
    
    public void valueChanged(ListSelectionEvent e)         //�б���ѡ���¼�������
    {
        String familyname=(String)list.getSelectedValue(); //�����б��ѡ�����������
//        System.out.println(" "+selected);  //һ��ѡ��ִ�����θ��¼�����Ϊʲô
        if (!tbook.isEmpty() && familyname!=null && familyname!="")  //��ѡ�����ϸ��±��
        {
            for (int i=this.tableModel.getRowCount()-1; i>=0; i--)   //��ձ��
                this.tableModel.removeRow(i);              
            Iterator it = tbook.iterator();
            while (it.hasNext())                           //�ڵ绰���в���ָ������
            {
                Friend f = (Friend)it.next();
                if (familyname=="ȫ��" || f.getName().charAt(0)==familyname.charAt(0))
                    this.tableModel.addRow(f.toArray());   //������һ�У���������ָ������ֵ
            }
        }
    }

    public void actionPerformed(ActionEvent e)             //�����¼�������
    {
        if (e.getActionCommand().equals("���"))           //������Ӱ�ť
        {
            String name=(String)combobox_name.getSelectedItem();
            String code=text_code.getText();
            Friend f = new Friend(name, code);
            if (!name.equals("") && !tbook.contains(f))    //�绰�����ܲ��������մ����ظ�����
            {
                tbook.add(f);                              //��Ӷ���TreeSet�������ظ�Ԫ�أ�û��ʾҲ���׳��쳣
                String familyname = name.charAt(0)+"";     //���������ĵ�һ���ַ�
                if (list.getSelectedValue().equals(familyname))
                    tableModel.addRow(f.toArray());     
                else
                {
                    if (!listModel.contains(familyname))   //�б������Ӳ��ظ�Ԫ��
                    {
                        listModel.addElement(familyname);
                        comboModel.addElement(familyname);
                    }
                    list.setSelectedValue(familyname,true);//�����б��ѡ����
                }
            }
            else
            	JOptionPane.showMessageDialog(this, "������������մ����ظ�����"+f.toString());
        }

        if (e.getActionCommand().equals("ɾ��"))
        {
            if (tbook.isEmpty())
                JOptionPane.showMessageDialog(this, "���գ�����ɾ�������");
            else
            {
                int i = table.getSelectedRow();            //���ǰѡ���к�
                if (i==-1)
                    JOptionPane.showMessageDialog(this, "��ѡ�������");
                else
                {
                    String name=(String)table.getValueAt(i,0);
                    int yes=JOptionPane.showConfirmDialog(null, "ɾ��\""+name+"\"�У�");//ȷ�϶Ի������Yes��No��ť
                    if (yes==0)                                    //����ȷ�϶Ի����Yes��ť
                    {
                        String code=(String)table.getValueAt(i,1);
                        tbook.remove(new Friend(name, code));      //�绰����ɾ������
                        tableModel.removeRow(i);                   //�����ɾ��һ��
                        listModel.removeElement(name.charAt(0)+"");//�б����ɾ��ָ������ 
                        comboModel.removeElement(name.charAt(0)+"");
                    }
                }
            }
        }
 
        if (!tbook.isEmpty() && e.getActionCommand().equals("���绰�������"))
        {                                                  //���ҵ绰���룬�����ʾ�ڱ����
            Friend find = null;
            Iterator it = tbook.iterator();
            while (find==null && it.hasNext())
            {
                Friend f = (Friend)it.next();
                if (f.getPhonecode().equals(text_code.getText()))  //�Ƚϵ绰�����ַ���
                    find = f;
            }
            if (find!=null)                                //�����ҳɹ�
            {
                for (int i=tableModel.getRowCount()-1; i>=0; i--) //��ձ��
                    this.tableModel.removeRow(i);                    
                this.tableModel.addRow(find.toArray());  
            }
            else JOptionPane.showMessageDialog(this, "δ���ҵ��������������ݣ�");
        }
    }
    
    public void windowClosing(WindowEvent e)               //�رմ����¼�������
    {
        try                                                //���绰�������ж���д��ָ���ļ�
        {                                              //ָ���ļ�������ʱ�����Ϊ�մ������ļ�
            FileOutputStream fout=new FileOutputStream(this.filename); //�ļ��ֽ������
            ObjectOutputStream objout=new ObjectOutputStream(fout);    //�����ֽ������
            if (!tbook.isEmpty())
            {
                Iterator it = tbook.iterator();
                while (it.hasNext())
                     objout.writeObject((Friend)it.next());     //д��һ������
            }
            objout.close();
            fout.close();
        }
        catch (IOException ioe){}
    }
    public void windowOpened(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
    public void windowClosed(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}

    public static void main(String args[])
    {
        new TelephoneBookJFrame();                         //Ĭ���ļ���Ϊ"frindes.dat"
    }    
}
    
/*
//        this.table_friends.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
˼���⣺�������¹��ܡ�
?	���绰�����λ����
?	���ӵ绰�����޸Ĺ��ܡ�
˫�����һ��,�ܹ��޸�,��Ӧ�¼������޸����ݡ�
*/
