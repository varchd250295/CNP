import java.io.*;
import java.net.*;

class IP_C
{
	public static void main(String args[])throws IOException
	{
		try
		{

			Socket s=new Socket("localhost",6666);

			System.out.println(" Client IP : " + s.getLocalSocketAddress());
			System.out.println(" Server IP : " + s.getRemoteSocketAddress());

		}

		catch(Exception e)
		{
			System.out.println(" No IP for you, Nigga! ");
		}
	}
}