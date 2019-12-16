//【例13.3】 列表框多项选择与数据移动。

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class MultiSelectJFrame extends JFrame implements FilenameFilter, ActionListener
{
    private JList list_source; 
    private DefaultListModel listModel_dest;                    //默认列表框模型类
    
    public MultiSelectJFrame()
    {
        super("列表框多项选择与数据移动"); 
        Dimension dim=getToolkit().getScreenSize();
        this.setBounds(dim.width/4,dim.height/4,dim.width/2,dim.height/2);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new GridLayout(1,3));
        
        String[] filenames = new File("国旗","").list(this);  //获得当前目录下指定子目录的文件名列表
        for (int i=0; i<filenames.length; i++)
        {      
            int index=filenames[i].lastIndexOf(".gif");
            filenames[i]=filenames[i].substring(0,index);        //获得文件名，去掉文件扩展名
        }
        list_source = new JList(filenames); 
        this.getContentPane().add(new JScrollPane(list_source));
        list_source.setCellRenderer(new CheckBoxListCellRenderer()); //设置自定义的单元渲染器
        
//        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
//        JPanel panel = new JPanel(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
        Box panel = new Box(BoxLayout.LINE_AXIS);
//        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.getContentPane().add(panel);
        JButton button_move = new JButton("〉");
        button_move.addActionListener(this);
        panel.add(button_move);

        this.listModel_dest = new DefaultListModel();      //默认列表框模式
        JList list_dest = new JList(listModel_dest);       //创建列表框
        this.getContentPane().add(list_dest);
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
        Object[] items=this.list_source.getSelectedValues();//获得列表框所有选中数据项
        for (int i=0; i<items.length; i++)
            this.listModel_dest.addElement(items[i]);      //列表框模型添加数据项
    }
    
    public static void main(String arg[])
    {
        new MultiSelectJFrame();
    }
}