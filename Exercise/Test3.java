package Exercise;

import java.text.SimpleDateFormat;
import java.util.Date;

//使用日期时间类编写应用程序，返回当天的年份，月份和日期并输出结果。
public class Test3 {
public static void main(String[] args) {
	Date date = new Date();
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	System.out.println("当前日期是："+df.format(date));
}
}
