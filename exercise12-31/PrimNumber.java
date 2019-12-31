package tom.jiafei;
public class PrimNumber 
{   public void getPrimnumber(int n)
{  int sum=0,i,j;
       for(i=1;i<=n;i++)  
{  for(j=2;j<=i/2;j++)
 {  if(i%j==0)
                   break;
          }
          if(j>i/2) 
            System.out.print(" "+i);
       }
     }
public static void main(String args[])
{  PrimNumber p=new PrimNumber();
       p.getPrimnumber(20); 
    }
}
