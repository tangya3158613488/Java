//����9.9��  �ļ����������ı��ļ��༭����  
//����12.7��  ���ĵ�������ı��ļ��༭���� 

import java.io.File;

public class FileExtensionFilter extends javax.swing.filechooser.FileFilter
{
    private String description, extension;                 //�ļ������������ļ���չ��
    
    public FileExtensionFilter(String description, String extension)
    {
        this.description = description;
        this.extension = extension.toLowerCase();
    }

    public boolean accept(File f)
    {
        return f.getName().toLowerCase().endsWith(this.extension);   //�ļ���չ��ƥ��
    }

    public String getDescription()
    {
        return this.description;
    }
}
