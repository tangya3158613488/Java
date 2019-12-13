//【例12.5】  电话簿。
//②	TelephoneBookJFrame类实现电话簿的存储、管理和图形用户界面。

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.io.*;

public class TelephoneBookJFrame extends JFrame implements ListSelectionListener, ActionListener, WindowListener
{
    private String filename;                               //文件名
    private TreeSet<Friend> tbook;                         //电话簿，使用一个树集合存储多个Friend对象
    private JList list;                                    //列表框
    private DefaultListModel listModel;                    //默认列表框模型
    private JTable table;                                  //表格组件
    private DefaultTableModel tableModel;                  //默认表格模型
    private JComboBox combobox_name;                       //姓名组合框
    private DefaultComboBoxModel comboModel;               //组合框模型，选择姓氏
    private JTextField text_code;                          //电话号码文本行

    public TelephoneBookJFrame(String filename)            //构造图形用户界面
    {
        super("电话簿");
        this.setBounds(300,300,450,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addWindowListener(this);                      //注册窗口事件监听器
        JSplitPane split_h=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT); //水平分割窗格
        split_h.setDividerLocation(40);                    //设置垂直分隔条的位置
        this.getContentPane().add(split_h);
        JSplitPane split_v=new JSplitPane(JSplitPane.VERTICAL_SPLIT); //垂直分割窗格
        split_v.setDividerLocation(180);                   //设置水平分隔条的位置

        this.filename = filename;
        tbook = new TreeSet<Friend>();
        this.readFromFile();                               //从指定文件中读取已有对象信息
        this.listModel = new DefaultListModel();           //默认列表框模型
        this.listModel.addElement("全部"); 
        this.list = new JList(listModel);                  //创建列表框
        this.list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //设置单选模式，默认为多选
        this.list.addListSelectionListener(this);          //列表框注册选择事件监听器
        split_h.add(new JScrollPane(this.list));           //添加在滚动窗格中
        split_h.add(split_v);
        
        String[] columns={"姓名","电话号码"};               //表格各列的中文标题
        this.tableModel=new DefaultTableModel(columns,0);  //默认表格模型，指定列标题，0行
        this.table=new JTable(tableModel);                 //创建空表格，有列标题
        this.list.setSelectedIndex(0);                     //选中列表框第一项，执行valueChanged()方法
        split_v.add(new JScrollPane(table));

        //以下面板包括组合框、文本行和添加、删除、查找等按钮
        JPanel friendpanel=new JPanel(new GridLayout(2,1)); 
        split_v.add(friendpanel);
        JPanel panels[]={new JPanel(), new JPanel()};
        for (int i=0; i<panels.length; i++)
            friendpanel.add(panels[i]);
        panels[0].add(new JLabel(columns[0]));
        this.comboModel = new DefaultComboBoxModel();      //默认组合框模型
        combobox_name = new JComboBox(this.comboModel); 
        combobox_name.setEditable(true);
        panels[0].add(combobox_name);
        panels[0].add(new JLabel(columns[1]));
        this.text_code = new JTextField("12345678901", 12);
        panels[0].add(text_code);
        this.getFamilyName();                              //列表框和组合框添加电话簿中的所有姓氏
            
        String buttonstr[]={"添加","删除","按电话号码查找"};
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
        this("friends.dat");                               //指定默认文件名
    }
    
    private void readFromFile()                            //从指定文件中读取已有对象
    {
        try
        {
            FileInputStream fin=new FileInputStream(this.filename);  //文件字节输入流
            ObjectInputStream objin=new ObjectInputStream(fin);      //对象字节输入流
            while (true)                                   //输入流未结束时
                try
                {
                    tbook.add((Friend)objin.readObject()); //读取一个对象添加到电话簿
                }
                catch (Exception e)                        //捕获ClassNotFoundException和EOFException异常 
                {
                    break;
                }
            objin.close();                                 //先关闭对象流
            fin.close();                                   //再关闭文件流
        }
        catch (IOException ioe){}                          //指定文件不存在时，表格为空
    }

    private void getFamilyName()                           //JList添加电话簿中的所有姓氏
    {
        if (!tbook.isEmpty())
        {
            Iterator it=tbook.iterator();                  //返回一个迭代器对象
            while (it.hasNext())                           //若有后继元素，使用迭代器遍历集合
            {
                Friend f=(Friend)it.next();                //返回后继元素
                String familyname=f.getName().charAt(0)+"";//获得姓氏
                if (!this.listModel.contains(familyname))
                {
                    this.listModel.addElement(familyname); //列表框模型添加不重复数据项
                    this.comboModel.addElement(familyname); //组合框模型添加不重复数据项
                }
            }
        }
    }
    
    public void valueChanged(ListSelectionEvent e)         //列表框的选择事件处理方法
    {
        String familyname=(String)list.getSelectedValue(); //返回列表框选中数据项对象
//        System.out.println(" "+selected);  //一次选择，执行两次该事件？？为什么
        if (!tbook.isEmpty() && familyname!=null && familyname!="")  //以选中姓氏更新表格
        {
            for (int i=this.tableModel.getRowCount()-1; i>=0; i--)   //清空表格
                this.tableModel.removeRow(i);              
            Iterator it = tbook.iterator();
            while (it.hasNext())                           //在电话簿中查找指定姓氏
            {
                Friend f = (Friend)it.next();
                if (familyname=="全部" || f.getName().charAt(0)==familyname.charAt(0))
                    this.tableModel.addRow(f.toArray());   //表格添加一行，参数数组指定各列值
            }
        }
    }

    public void actionPerformed(ActionEvent e)             //单击事件处理方法
    {
        if (e.getActionCommand().equals("添加"))           //单击添加按钮
        {
            String name=(String)combobox_name.getSelectedItem();
            String code=text_code.getText();
            Friend f = new Friend(name, code);
            if (!name.equals("") && !tbook.contains(f))    //电话簿不能插入姓名空串和重复对象
            {
                tbook.add(f);                              //添加对象，TreeSet不插入重复元素，没提示也不抛出异常
                String familyname = name.charAt(0)+"";     //返回姓名的第一个字符
                if (list.getSelectedValue().equals(familyname))
                    tableModel.addRow(f.toArray());     
                else
                {
                    if (!listModel.contains(familyname))   //列表框中添加不重复元素
                    {
                        listModel.addElement(familyname);
                        comboModel.addElement(familyname);
                    }
                    list.setSelectedValue(familyname,true);//设置列表框选中项
                }
            }
            else
            	JOptionPane.showMessageDialog(this, "不能添加姓名空串或重复对象"+f.toString());
        }

        if (e.getActionCommand().equals("删除"))
        {
            if (tbook.isEmpty())
                JOptionPane.showMessageDialog(this, "表格空，不能删除数据项。");
            else
            {
                int i = table.getSelectedRow();            //表格当前选中行号
                if (i==-1)
                    JOptionPane.showMessageDialog(this, "请选择数据项。");
                else
                {
                    String name=(String)table.getValueAt(i,0);
                    int yes=JOptionPane.showConfirmDialog(null, "删除\""+name+"\"行？");//确认对话框包括Yes和No按钮
                    if (yes==0)                                    //单击确认对话框的Yes按钮
                    {
                        String code=(String)table.getValueAt(i,1);
                        tbook.remove(new Friend(name, code));      //电话簿中删除对象
                        tableModel.removeRow(i);                   //表格中删除一行
                        listModel.removeElement(name.charAt(0)+"");//列表框中删除指定姓氏 
                        comboModel.removeElement(name.charAt(0)+"");
                    }
                }
            }
        }
 
        if (!tbook.isEmpty() && e.getActionCommand().equals("按电话号码查找"))
        {                                                  //查找电话号码，结果显示在表格中
            Friend find = null;
            Iterator it = tbook.iterator();
            while (find==null && it.hasNext())
            {
                Friend f = (Friend)it.next();
                if (f.getPhonecode().equals(text_code.getText()))  //比较电话号码字符串
                    find = f;
            }
            if (find!=null)                                //若查找成功
            {
                for (int i=tableModel.getRowCount()-1; i>=0; i--) //清空表格
                    this.tableModel.removeRow(i);                    
                this.tableModel.addRow(find.toArray());  
            }
            else JOptionPane.showMessageDialog(this, "未查找到满足条件的数据！");
        }
    }
    
    public void windowClosing(WindowEvent e)               //关闭窗口事件处理方法
    {
        try                                                //将电话簿中所有对象写入指定文件
        {                                              //指定文件不存在时，表格为空创建新文件
            FileOutputStream fout=new FileOutputStream(this.filename); //文件字节输出流
            ObjectOutputStream objout=new ObjectOutputStream(fout);    //对象字节输出流
            if (!tbook.isEmpty())
            {
                Iterator it = tbook.iterator();
                while (it.hasNext())
                     objout.writeObject((Friend)it.next());     //写入一个对象
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
        new TelephoneBookJFrame();                         //默认文件名为"frindes.dat"
    }    
}
    
/*
//        this.table_friends.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
思考题：增加以下功能。
?	检查电话号码的位数。
?	增加电话簿的修改功能。
双击表格一列,能够修改,响应事件保存修改内容。
*/
