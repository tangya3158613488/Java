//【例12.7】  多文档界面的文本文件编辑器。  

import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.beans.PropertyVetoException;

public class MDITextFileEditorJFrame extends JFrame implements ActionListener
{
    private JDesktopPane desktop;                          //桌面窗格
    private JFileChooser fchooser;                         //选择文件对话框
    
    public MDITextFileEditorJFrame()                       //空文件的构造方法
    {
        super("文本文件编辑器");
        this.setBounds(400,300,600,480);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        desktop=new JDesktopPane();                        //桌面窗格
        this.getContentPane().add(desktop);                //将桌面窗格添加到框架的内容窗格

        JMenuBar menubar = new JMenuBar();
        this.setJMenuBar(menubar);
        String menustr[]={"文件","编辑","插入","格式","工具","窗口","帮助"};
        JMenu menu[] = new JMenu[menustr.length];
        for (int i=0; i<menu.length; i++)                  //菜单栏添加文件等若干菜单
        {
            menu[i] = new JMenu(menustr[i]);
            menubar.add(menu[i]);
        }        
        String menuitemstr[]={"新建","打开","保存","另存为","退出"};
        JMenuItem menuitem[] = new JMenuItem[menuitemstr.length];
        for (int i=0; i<menuitem.length; i++)              //文件菜单添加若干菜单项
        {
            menuitem[i] = new JMenuItem(menuitemstr[i]);
            menu[0].add(menuitem[i]);
            menuitem[i].addActionListener(this);
        }
        menu[0].insert(new JMenu("最近打开文件"), 4);      //文件菜单插入子菜单
        this.setVisible(true);
        
        this.fchooser = new JFileChooser(new File("唐诗","")); //指定打开文件对话框的起始路径
        this.fchooser.setFileFilter(new FileExtensionFilter("文本文件(*.txt)","txt"));//设置文件过滤器
    }

    public MDITextFileEditorJFrame(File file)              //指定文件对象的构造方法
    {
        this();        
        if (file!=null)
            new TextJIFrame(file);                         //创建自定义的内部框架
    }
    
    public MDITextFileEditorJFrame(String filename)        //指定文件名的构造方法
    {
        this();        
        if (filename!=null)
            new TextJIFrame(filename); 
    }

    private class TextJIFrame extends JInternalFrame       //创建自定义的内部框架
    {
        File file;                                         //当前文件
        JTextArea text;                                    //文本区 

        TextJIFrame() 
        {
            super("未命名", true, true, true, true);
            this.setSize(400, 300);
            desktop.add(this);
            JInternalFrame inner = desktop.getSelectedFrame();
            if (inner!=null)                               //设置各内部框架级联显示
            	this.setLocation(inner.getX()+50, inner.getY()+50);
            this.file = null;                              //空文件对象
            this.text = new JTextArea();
            this.getContentPane().add(new JScrollPane(this.text));
            this.setVisible(true);
        }

        TextJIFrame(File file)                             //file指定文件
        {
            this();
            if (file!=null)
            {
                this.file = file;
                this.setTitle(file.getName());
                this.text.setText(this.readFromFile());   //读取file文件内容显示在文本区中
            }
        }
    
        TextJIFrame(String filename)                      //filename指定文件名
        {
            this(new File(filename));
        }
        
        String readFromFile()                             //使用流从当前文本文件中读取字符串
        {
            try
            {
                FileReader fin=new FileReader(this.file);  //创建字符输入流对象
                char contents[]=new char[(int)this.file.length()];
                fin.read(contents);                        //读取字符输入流到字符数组
                fin.close();
                return new String(contents);
            }
            catch (FileNotFoundException fe)
            {
                JOptionPane.showMessageDialog(this, "\""+this.file.getName()+"\"文件不存在");
            }
            catch (IOException ioex)
            {
                JOptionPane.showMessageDialog(this, "IO错，读取\""+this.file.getName()+"\"文件不成功");
            }
            return null;
        }    

        void writeToFile(String lines)                     //将lines字符串写入当前文本文件中
        {
            try
            {
                FileWriter fout=new FileWriter(this.file); //创建字符输出流对象
                fout.write(lines+"\r\n");                  //向文件字符输出流写入一个字符串
                fout.close();
            }
            catch (IOException ioex)
            {
                JOptionPane.showMessageDialog(this, "IO错，写入\""+this.file.getName()+"\"文件不成功");
            }
        }
    }//TextJIFrame内部类结束
    
    public void actionPerformed(ActionEvent e)             //单击事件处理方法，单击菜单项时
    {
        if (e.getActionCommand()=="新建")
        {
            new TextJIFrame();                             //创建内部框架
            return; 
        }
        if (e.getActionCommand()=="打开" && fchooser.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
        {                                                  //显示打开文件对话框，且单击【打开】按钮
            File currfile = fchooser.getSelectedFile();    //获得文件对话框的当前选中文件
            JInternalFrame inners[]=desktop.getAllFrames();//返回桌面窗格中的所有内部框架
            int i=0;                                       //以下查找currfile文件是否已打开
//            System.out.println("inners.length="+inners.length);
//        	System.out.println("currfile.getAbsolutePath()="+currfile.getAbsolutePath());
            while (i<inners.length)
            {
                File f=((TextJIFrame)inners[i]).file;
 //               System.out.println("i="+i+" "+(f==null ? "null" : f.getAbsolutePath()));
                if (f==null || !currfile.getAbsolutePath().equals(f.getAbsolutePath()))
                    i++;
                else
                    break;
            }
            if (i<inners.length)
                try
                {
                    inners[i].setSelected(true);           //选中当前内部框架，不重复打开
                }
                catch(PropertyVetoException pve)
                {
                    pve.printStackTrace();
                }
            else
                new TextJIFrame(currfile);
            return;
        }
        
        TextJIFrame inner=(TextJIFrame)desktop.getSelectedFrame();//返回桌面窗格中当前活动内部框架
        if (e.getActionCommand()=="保存" && inner.file!=null) //保存非空文件，不显示保存文件对话框
            inner.writeToFile(inner.text.getText());
        else
            if ((e.getActionCommand()=="保存" && inner.file==null || e.getActionCommand()=="另存为")
                && fchooser.showSaveDialog(this)==JFileChooser.APPROVE_OPTION)
            {                      //保存空文件或执行"另存为"菜单项时，显示保存文件对话框，且单击【保存】按钮
                inner.file = fchooser.getSelectedFile();
                if (!inner.file.getName().endsWith(".txt"))
                    inner.file= new File(inner.file.getAbsolutePath()+".txt");  //添加文件扩展名
                inner.setTitle(inner.file.getName());
                inner.writeToFile(inner.text.getText());
            }
    }

    public static void main(String arg[])
    {
        new MDITextFileEditorJFrame("唐诗\\忆江南.txt");
    }
}
