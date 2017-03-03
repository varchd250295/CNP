import java.io.*;
import java.net.*;

class IP_S
{
	public static void main(String args[])throws IOException
	{
		try
		{

			ServerSocket ss=new ServerSocket(6666);
			Socket s=ss.accept();

		}

		catch(Exception e)
		{
			System.out.println(" SERVERed! ");
		}
	}
}