//【例12.5】  电话簿。
//①	Friend类表示电话簿中的对象。

public class Friend implements java.lang.Comparable<Friend>, java.io.Serializable  // 实现可比较和序列化接口
{
    private String name;                                   //姓名
    private String phonecode;                              //电话号码

    public Friend(String name, String phonecode)           //构造方法
    {
        this.name = name;
        this.phonecode = phonecode;
    }
    public String getName()                                //获得姓名
    {
        return this.name;
    }
    public String getPhonecode()                           //获得电话号码
    {
        return this.phonecode;
    }

    public String toString() 
    {
        return "("+this.name+", "+this.phonecode+")";
    }

    public int compareTo(Friend f)                         //比较两个对象大小，实现Comparable接口
    {                                                      //指定排序次序
        if (!this.name.equals(f.name))     
            return this.name.compareTo(f.name);            //两人以姓名为序
        else
            return this.phonecode.compareTo(f.phonecode);  //同一人以电话号码为序
    }

    public Object[] toArray()                              //将对象的两个成员变量保存在对象数组中
    {
        Object[] vars = new Object[2];
        vars[0] = this.name;
        vars[1] = this.phonecode;
        return vars;
    }
}

/*
程序设计说明如下。
 *若两对象仅比较姓名，声明如下，则电话簿中不能添加一个人的两个电话号码
    public int compareTo(Friend f)                         //比较两人姓名
    {                                                      //指定排序的自然次序
        return this.name.compareTo(f.name);
    }


//以下方法未用
    public void set(String name, String phonecode)         //设置成员变量值
    {
        this.setName(name);
        this.setPhonecode(phonecode);
    }
    public boolean equals(Object obj)                      //覆盖Object类中方法
    {
        if (this==obj)
        	return true;
        	
        if (obj instanceof Friend)                         //判断当前对象是否属于Friend类
        {
            Friend f = (Friend)obj;
            return this.name.equals(f.name) && this.phonecode.equals(f.phonecode);
        }
        return false;
    }
*/