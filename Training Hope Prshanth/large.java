import java.util.*;
public class large{
    public static int greater(int a,int b,int c){
       /* if(a>b && a>c){
            return a;
        }
        else if(b>a && b>c){
            return b;
        }
        else 
        {
            return c;
        }*/
       return (int)(Math.max((int)Math.max(a,b),c));
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter girl");
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        System.out.println(greater(a,b,c));
    }
}