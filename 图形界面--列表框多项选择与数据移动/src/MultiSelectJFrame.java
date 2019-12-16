//【例12.4】 列表框多项选择与数据移动。

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class MultiSelectJFrame extends JFrame implements FilenameFilter, ActionListener
{
    private JList list_source; 
    private DefaultListModel listModel_source, listModel_dest; //默认列表框模型类
    
    public MultiSelectJFrame()
    {
        super("列表框多项选择与数据移动"); 
        this.setBounds(200,200,400,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(),BoxLayout.X_AXIS));//.LINE_AXIS));
                                                           //盒式水平布局
        this.listModel_source = new DefaultListModel();    //默认列表框模式
        String[] filenames=new File("国旗","").list(this); //获得当前目录下指定子目录的文件名列表
        for (int i=0; i<filenames.length; i++)
        {      
            int index=filenames[i].lastIndexOf(".gif");
            this.listModel_source.addElement(filenames[i].substring(0,index));
                                                           //将文件名（不包含文件扩展名）添加到列表框模式
        }
        list_source = new JList(this.listModel_source);    //创建列表框，指定列表框模式
        this.getContentPane().add(new JScrollPane(list_source));
        list_source.setCellRenderer(new CheckBoxListCellRenderer()); //设置自定义的单元渲染器
        
        Box box = new Box(BoxLayout.Y_AXIS);               //Box容器以盒式垂直布局 
        this.getContentPane().add(box);
        JButton button1 = new JButton("　〉");
        button1.addActionListener(this);
        box.add(button1);
        JButton button2 = new JButton("〉〉");
        button2.addActionListener(this);
        box.add(button2);

        this.listModel_dest = new DefaultListModel();
        JList list_dest = new JList(listModel_dest);             //创建列表框
        this.getContentPane().add(new JScrollPane(list_dest));
        this.setVisible(true);
    }

    class CheckBoxListCellRenderer extends JCheckBox implements ListCellRenderer
    {                                                      //列表框单元渲染器，必须是内部类
        public Component getListCellRendererComponent(JList list,Object value,int index,boolean isSelected,boolean cellHasFocus)
        {
            setText(value.toString());
            setBackground(isSelected ? Color.lightGray : Color.white);  //选中数据项背景浅灰色
            setForeground(isSelected ? Color.red : Color.black);        //选中数据项红色显示
//            setSelected(isSelected);                                    //当前数据项选中状态
            setIcon(new ImageIcon(".\\国旗\\"+value.toString()+".gif")); //添加图标
            return this;
        }
    }
    
    public boolean accept(File dir, String filename)       //文件过滤方法，实现文件过滤器接口
    {
        return filename.toLowerCase().endsWith(".gif");    //文件扩展名匹配
    }    
    
    public void actionPerformed(ActionEvent e)             //单击事件处理方法，单击按钮
    {
        if (e.getActionCommand()=="　〉")
        {
            Object[] items=this.list_source.getSelectedValues();//获得列表框所有选中数据项
            for (int i=0; i<items.length; i++)
                this.listModel_dest.addElement(items[i]);  //列表框模型添加数据项
        }
        else                                               //单击"〉〉"按钮
        {
            this.listModel_dest.removeAllElements();       //删除所有数据项
            int count=listModel_source.getSize();          //获得列表框的数据项数
            for (int i=0; i<count; i++)
                this.listModel_dest.addElement(listModel_source.elementAt(i));
        }
    }
    
    public static void main(String arg[])
    {
        new MultiSelectJFrame();
    }
}