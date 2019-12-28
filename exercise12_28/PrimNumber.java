package exercise12_28;

public class PrimNumber
{
	public void getPrimnumber(int n)
	{ 
		int i,j;
		for(i=2;i<=n;i++)
		{
			for(j=2;j<=i/2;j++)
			{
				if(i%j==0)
					break; 
			}
			if(j>i/2)
				System.out.print(" "+i);
		}
	}
	public static void main(String args[])
	{ 
	PrimNumber num=new PrimNumber();
	num.getPrimnumber(30);
	}
}

