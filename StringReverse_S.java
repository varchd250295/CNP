import java.io.*;
import java.net.*;
class StringReverse_S
{
	public static void main(String args[])throws IOException
	{
		try
		{

			ServerSocket ss=new ServerSocket(6666);
			Socket s=ss.accept();						// establishes connection

			String Sstr,Cstr="";

			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));    // returns object of DataOutputStream to be encapsulated in OutputStreamWriter to be encapsulated in BufferedWriter
			BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));	  // returns object of DataInputStream to be encapsulated in InputStreamReaderto be encapsulated in BufferedReader
			BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));

			Cstr=br.readLine();

			Sstr=new StringBuilder(Cstr).reverse().toString();

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