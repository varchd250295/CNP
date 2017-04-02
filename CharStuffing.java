import java.util.*;
class Charstuffing
{
    public static void main(String r[])
    {    
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of characters: ");
        int n=sc.nextInt();
        String in[]=new String[n];
        for(int i=0;i<n;i++)
        {
            in[i]=sc.next();
        }
        for(int i= 0;i<n;i++)
        {
            if(in[i].equals("dle"))
            {
                in[i]="dle dle";
            }
        }
        System.out.println("Transmitted message is: ");
        System.out.print(" dle stx ");
        for(int i=0;i<n;i++)
        {
            System.out.print(in[i]+" ");
        }
        System.out.println(" dle etx ");
		System.out.println("The message at the receiver end");
		for(int i= 0;i<n;i++)
        {
            if(in[i].equals("dle dle"))
            {
                in[i]="dle";
            }
        }
		for(int i=0;i<n;i++)
        {
            System.out.print(in[i]+" ");
        }
    }
}