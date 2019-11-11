package P5;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MonthCalendar {
	public String toString()                     //返回当月的月历
    {
        Calendar now = Calendar.getInstance();   //当前日期和时间
        int year =now.get(Calendar.YEAR);        //年
        int month=now.get(Calendar.MONTH)+1;     //月
        now.set(year, month-1, 1);               //设置为当月1日
        int week = now.get(Calendar.DAY_OF_WEEK)-1;  //当月1日是星期几

        String str=year+"年"+month+"月的月历\n  日     一     二    三    四    五   六\n";
        str+=String.format("%"+4*week+"c", ' ');     //前导空格
         int days=now.getActualMaximum(now.DATE);   //计算出当月的天数
        for (int i=1; i<=days; i++)
        {
            str+=String.format("%4d", i);
            if ((week+i)%7==0)
                str+="\n";
        }
        return str;
    }
    
    public static void main (String args[])
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日EEEEE a hh时mm分ss秒");    //定义日期格式
        System.out.println(sdf.format(new Date()));   //当前日期和时间
        System.out.println(new MonthCalendar().toString());
    }
}
