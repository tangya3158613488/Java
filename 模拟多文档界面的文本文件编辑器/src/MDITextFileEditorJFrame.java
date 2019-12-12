//����12.7��  ���ĵ�������ı��ļ��༭����  

import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.beans.PropertyVetoException;

public class MDITextFileEditorJFrame extends JFrame implements ActionListener
{
    private JDesktopPane desktop;                          //���洰��
    private JFileChooser fchooser;                         //ѡ���ļ��Ի���
    
    public MDITextFileEditorJFrame()                       //���ļ��Ĺ��췽��
    {
        super("�ı��ļ��༭��");
        this.setBounds(400,300,600,480);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        desktop=new JDesktopPane();                        //���洰��
        this.getContentPane().add(desktop);                //�����洰����ӵ���ܵ����ݴ���

        JMenuBar menubar = new JMenuBar();
        this.setJMenuBar(menubar);
        String menustr[]={"�ļ�","�༭","����","��ʽ","����","����","����"};
        JMenu menu[] = new JMenu[menustr.length];
        for (int i=0; i<menu.length; i++)                  //�˵�������ļ������ɲ˵�
        {
            menu[i] = new JMenu(menustr[i]);
            menubar.add(menu[i]);
        }        
        String menuitemstr[]={"�½�","��","����","���Ϊ","�˳�"};
        JMenuItem menuitem[] = new JMenuItem[menuitemstr.length];
        for (int i=0; i<menuitem.length; i++)              //�ļ��˵�������ɲ˵���
        {
            menuitem[i] = new JMenuItem(menuitemstr[i]);
            menu[0].add(menuitem[i]);
            menuitem[i].addActionListener(this);
        }
        menu[0].insert(new JMenu("������ļ�"), 4);      //�ļ��˵������Ӳ˵�
        this.setVisible(true);
        
        this.fchooser = new JFileChooser(new File("��ʫ","")); //ָ�����ļ��Ի������ʼ·��
        this.fchooser.setFileFilter(new FileExtensionFilter("�ı��ļ�(*.txt)","txt"));//�����ļ�������
    }

    public MDITextFileEditorJFrame(File file)              //ָ���ļ�����Ĺ��췽��
    {
        this();        
        if (file!=null)
            new TextJIFrame(file);                         //�����Զ�����ڲ����
    }
    
    public MDITextFileEditorJFrame(String filename)        //ָ���ļ����Ĺ��췽��
    {
        this();        
        if (filename!=null)
            new TextJIFrame(filename); 
    }

    private class TextJIFrame extends JInternalFrame       //�����Զ�����ڲ����
    {
        File file;                                         //��ǰ�ļ�
        JTextArea text;                                    //�ı��� 

        TextJIFrame() 
        {
            super("δ����", true, true, true, true);
            this.setSize(400, 300);
            desktop.add(this);
            JInternalFrame inner = desktop.getSelectedFrame();
            if (inner!=null)                               //���ø��ڲ���ܼ�����ʾ
            	this.setLocation(inner.getX()+50, inner.getY()+50);
            this.file = null;                              //���ļ�����
            this.text = new JTextArea();
            this.getContentPane().add(new JScrollPane(this.text));
            this.setVisible(true);
        }

        TextJIFrame(File file)                             //fileָ���ļ�
        {
            this();
            if (file!=null)
            {
                this.file = file;
                this.setTitle(file.getName());
                this.text.setText(this.readFromFile());   //��ȡfile�ļ�������ʾ���ı�����
            }
        }
    
        TextJIFrame(String filename)                      //filenameָ���ļ���
        {
            this(new File(filename));
        }
        
        String readFromFile()                             //ʹ�����ӵ�ǰ�ı��ļ��ж�ȡ�ַ���
        {
            try
            {
                FileReader fin=new FileReader(this.file);  //�����ַ�����������
                char contents[]=new char[(int)this.file.length()];
                fin.read(contents);                        //��ȡ�ַ����������ַ�����
                fin.close();
                return new String(contents);
            }
            catch (FileNotFoundException fe)
            {
                JOptionPane.showMessageDialog(this, "\""+this.file.getName()+"\"�ļ�������");
            }
            catch (IOException ioex)
            {
                JOptionPane.showMessageDialog(this, "IO����ȡ\""+this.file.getName()+"\"�ļ����ɹ�");
            }
            return null;
        }    

        void writeToFile(String lines)                     //��lines�ַ���д�뵱ǰ�ı��ļ���
        {
            try
            {
                FileWriter fout=new FileWriter(this.file); //�����ַ����������
                fout.write(lines+"\r\n");                  //���ļ��ַ������д��һ���ַ���
                fout.close();
            }
            catch (IOException ioex)
            {
                JOptionPane.showMessageDialog(this, "IO��д��\""+this.file.getName()+"\"�ļ����ɹ�");
            }
        }
    }//TextJIFrame�ڲ������
    
    public void actionPerformed(ActionEvent e)             //�����¼��������������˵���ʱ
    {
        if (e.getActionCommand()=="�½�")
        {
            new TextJIFrame();                             //�����ڲ����
            return; 
        }
        if (e.getActionCommand()=="��" && fchooser.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
        {                                                  //��ʾ���ļ��Ի����ҵ������򿪡���ť
            File currfile = fchooser.getSelectedFile();    //����ļ��Ի���ĵ�ǰѡ���ļ�
            JInternalFrame inners[]=desktop.getAllFrames();//�������洰���е������ڲ����
            int i=0;                                       //���²���currfile�ļ��Ƿ��Ѵ�
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
                    inners[i].setSelected(true);           //ѡ�е�ǰ�ڲ���ܣ����ظ���
                }
                catch(PropertyVetoException pve)
                {
                    pve.printStackTrace();
                }
            else
                new TextJIFrame(currfile);
            return;
        }
        
        TextJIFrame inner=(TextJIFrame)desktop.getSelectedFrame();//�������洰���е�ǰ��ڲ����
        if (e.getActionCommand()=="����" && inner.file!=null) //����ǿ��ļ�������ʾ�����ļ��Ի���
            inner.writeToFile(inner.text.getText());
        else
            if ((e.getActionCommand()=="����" && inner.file==null || e.getActionCommand()=="���Ϊ")
                && fchooser.showSaveDialog(this)==JFileChooser.APPROVE_OPTION)
            {                      //������ļ���ִ��"���Ϊ"�˵���ʱ����ʾ�����ļ��Ի����ҵ��������桿��ť
                inner.file = fchooser.getSelectedFile();
                if (!inner.file.getName().endsWith(".txt"))
                    inner.file= new File(inner.file.getAbsolutePath()+".txt");  //����ļ���չ��
                inner.setTitle(inner.file.getName());
                inner.writeToFile(inner.text.getText());
            }
    }

    public static void main(String arg[])
    {
        new MDITextFileEditorJFrame("��ʫ\\�佭��.txt");
    }
}
