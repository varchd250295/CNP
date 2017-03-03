import java.io.*;
import java.net.*;
class TwoWay_C
{
	public static void main(String args[])throws IOException
	{
		try
		{

			Socket s=new Socket("localhost",6666);

			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));    // returns object of DataOutputStream to be encapsulated in OutputStreamWriter to be encapsulated in BufferedWriter
			BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));	  // returns object of DataInputStream to be encapsulated in InputStreamReaderto be encapsulated in BufferedReader
			BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));

			String Cstr,Sstr="";

			while(!Sstr.equalsIgnoreCase("Stahp"))
			{

				System.out.println(" Reply, Pls : ");
				Cstr=buf.readLine();
				bw.write(Cstr);
				bw.newLine();
				bw.flush();

				Sstr=br.readLine();
				System.out.println(" Mah Server: " + Sstr);

			}

			bw.flush();
			bw.close();
			s.close();

		}

		catch(Exception e)
		{
			System.out.println(" Nigga, you fucked up ! ");
		}

	}
}