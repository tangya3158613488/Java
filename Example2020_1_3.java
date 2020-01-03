import java.awt.*;
import java.awt.event.*;
class WindowChoice extends Frame 
implements ItemListener,ActionListener
{  Choice choice; 
   TextField text;
   TextArea area;
   Button add,del;
   WindowChoice()
   {  setLayout(new FlowLayout());
      choice=new Choice(); 
      text=new TextField(8);
      area=new TextArea(6,25);  
      choice.add("�������"); 
      choice.add("�������");
      choice.add("������԰");     
      choice.add("��������");
      add=new Button("���");
      del=new Button("ɾ��");
      add.addActionListener(this);
      text.addActionListener(this);
      del.addActionListener(this);
      choice.addItemListener(this);
      add(choice);  
      add(del);
      add(text);
      add(add);
      add(area);
      setSize(200,200);
      setVisible(true);
      validate();
   }
   public void itemStateChanged(ItemEvent e)
   {  String name=choice.getSelectedItem();
      int index=choice.getSelectedIndex();
      area.setText("\n"+index+":"+name);
   }
   public void actionPerformed(ActionEvent e)
   {  if(e.getSource()==add||e.getSource()==text)
        {  String name=text.getText();
           if(name.length()>0)
              {  choice.add(name);
                 choice.select(name);
                 area.append("\n�б���ӣ�"+name);
              }
        }
      else if(e.getSource()==del)
        {   area.append("\n�б�ɾ����"+choice.getSelectedItem());
            choice.remove(choice.getSelectedIndex());
        }
   }
} 
public class Example8_2_5
{   public static void main(String args[])
    {  new WindowChoice(); 
    }
}
