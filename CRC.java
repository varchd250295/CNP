import java.io.*;
import java.util.Random;
class CRC
{
	static String divide(String s1)
	{
		String temp=s1.substring(0,4);
		int length=s1.length();
		for(int i=4;i<=length;i++)
		{
			if(temp.charAt(0)=='0')
			{
				if(i==length)
					temp=temp.substring(1);
				else
					temp=temp.substring(1)+s1.charAt(i);
				continue;
			}
			String s2="";
			s2+=temp.charAt(1);
			s2+=(temp.charAt(2)=='0')?'1':'0';
			s2+=(temp.charAt(3)=='0')?'1':'0';
			if(i!=length)
			s2+=s1.charAt(i);
			temp=s2;
		}
		return temp;
	}
	public static void main(String args[])throws IOException
	{
		BufferedReader xx=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the binary string :");
		String s1=xx.readLine();
		String temp=divide(s1+"000");
		String codeword=s1+temp;
		int length=codeword.length();
		s1=""+codeword;
		Random rand=new Random();
		int r1=rand.nextInt(length);
		System.out.println(length);
		for(int i=0;i<r1;i++)
		{
			int r2=rand.nextInt(length-1);
			if(codeword.charAt(r2)=='1')
				codeword=codeword.substring(0,r2)+"0"+codeword.substring(r2+1);
			else
				codeword=codeword.substring(0,r2)+"1"+codeword.substring(r2+1);
		}
		System.out.println("The sent string is : "+s1);
		System.out.println("The received string is :"+codeword);
		if(Integer.parseInt(divide(codeword))==0)
			System.out.println("No Errors!");
		else
			System.out.println("Error(s) detected!");
	}
}