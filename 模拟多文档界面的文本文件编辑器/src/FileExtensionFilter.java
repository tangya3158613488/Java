//【例9.9】  文件管理器和文本文件编辑器。  
//【例12.7】  多文档界面的文本文件编辑器。 

import java.io.File;

public class FileExtensionFilter extends javax.swing.filechooser.FileFilter
{
    private String description, extension;                 //文件类型描述，文件扩展名
    
    public FileExtensionFilter(String description, String extension)
    {
        this.description = description;
        this.extension = extension.toLowerCase();
    }

    public boolean accept(File f)
    {
        return f.getName().toLowerCase().endsWith(this.extension);   //文件扩展名匹配
    }

    public String getDescription()
    {
        return this.description;
    }
}
