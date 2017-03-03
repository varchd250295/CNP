import java.io.*;
import java.net.*;
class SocketSample_S
{
	public static void main(String args[])throws IOException
	{
		try
		{

			ServerSocket ss=new ServerSocket(6666);
			Socket s=ss.accept();						// establishes connection

			String str;

			BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));	  // returns object of DataInputStream to be encapsulated in InputStreamReaderto be encapsulated in BufferedReader
			BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));

			str=br.readLine();

			System.out.println(" Mah Client : " + str);

			ss.close();
			s.close();

		}

		catch(Exception e)
		{
			System.out.println(" Nigga, you just got SERVERed ");
		}

	}
}