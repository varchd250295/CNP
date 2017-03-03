import java.io.*;
import java.net.*;
class SocketSample_C
{
	public static void main(String args[])throws IOException
	{
		try
		{

			Socket s=new Socket("localhost",6666);

			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));    // returns object of DataOutputStream to be encapsulated in OutputStreamWriter to be encapsulated in BufferedWriter
			BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));

			String str;

			str=buf.readLine();

			bw.write(str);
			bw.newLine();

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