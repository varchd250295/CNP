 import java.io.*;
import java.net.*;
import java.util.*;

class Calculator_S
{
	public static void main(String args[])throws IOException
	{
		try
		{

			ServerSocket ss=new ServerSocket(6666);
			Socket s=ss.accept();						// establishes connection

			String Sstr,Cstr="";
			double exp=0;

			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));    // returns object of DataOutputStream to be encapsulated in OutputStreamWriter to be encapsulated in BufferedWriter
			BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));	  // returns object of DataInputStream to be encapsulated in InputStreamReaderto be encapsulated in BufferedReader
			BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));

			Cstr=br.readLine();
			System.out.println(" Client's Expression : " + Cstr);

			StringTokenizer st=new StringTokenizer(Cstr,"/*+-%");

			for(int i=0;i<Cstr.length();i++)
			{
				if(!(Cstr.charAt(i)>=0 && Cstr.charAt(i)<=9))
					switch(Cstr.charAt(i))
					{
						case '+' :	exp=Double.parseDouble(st.nextToken()) + Double.parseDouble(st.nextToken()); break;
						case '-' :	exp=Double.parseDouble(st.nextToken()) - Double.parseDouble(st.nextToken()); break;
						case '/' :	exp=Double.parseDouble(st.nextToken()) / Double.parseDouble(st.nextToken()); break;
						case '*' :	exp=Double.parseDouble(st.nextToken()) * Double.parseDouble(st.nextToken()); break;
						case '%' :	exp=Double.parseDouble(st.nextToken()) % Double.parseDouble(st.nextToken()); break;
					}

			}

			Sstr=exp+"";

			bw.write(Sstr);
			bw.newLine();
			bw.flush();

			bw.flush();
			bw.close();
			s.close();
			ss.close();

		}

		catch(Exception e)
		{
			System.out.println(" Nigga, you just got SERVERed ");
		}

	}
}