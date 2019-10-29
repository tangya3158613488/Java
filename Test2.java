
import java.util.*;
class OpenCount{
	String name;
	String password;
	int money;
	public void getimfor(String name,String password,int money)
	{
		this.name=name;
		this.password=password;
		this.money=money;
		System.out.println("新增一个用户：姓名"+name+"、密码"+password+"、账户余额"+money);
	}
}

public class Test2 {
public static void main(String[] args) {
	System.out.println("欢迎新用户到银行办理现金存取业务:");
	System.out.println("请先开户");
	
	OpenCount num1 = new OpenCount();
	System.out.println("请输入新用户的姓名、密码、初始充值额：");
	Scanner s1 = new Scanner(System.in);
	while(s1.hasNext())
	{	
		String sname = s1.next();
		String spassword = s1.next();
		int smoney1 = s1.nextInt()-10;
		//OpenCount num1 = new OpenCount();
		System.out.println("已扣除10元开卡费");
		num1.getimfor(sname,spassword,smoney1);
		break;
	}
	
	System.out.println("开户成功，请继续选择你要办理的业务:");
	System.out.println("**********************2.存款:");
	System.out.println("3.取款:*******************4.离开:");
	while(true)
	{
		Scanner sj = new Scanner(System.in);
		int j = sj.nextInt();
		switch(j)
		{
		case 2:
			System.out.println("请输入存款金额：");
			Scanner s2 = new Scanner(System.in);
			int smoney2 = s2.nextInt();
			num1.money += smoney2;
			System.out.println("您目前的账户余额为"+num1.money);
			break;
		case 3:
			System.out.println("请输入取款金额：");
			Scanner s3 = new Scanner(System.in);
			int smoney3 = s3.nextInt();
			if(smoney3 > num1.money)
			{
				System.out.println("账户余额不足！");
			}
			else
			{
				num1.money -= smoney3;
				System.out.println("您目前的账户余额为"+num1.money);
			}
			break;
		case 4:
			System.out.println("请带好随身物品，欢迎下次光临");
			break;
		default:
			System.out.println("请正确输入您所要办理的业务！");	
			break;
		}
	}
 }
}