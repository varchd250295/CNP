import java.io.*;
import java.security.*;
import javax.crypto.*;
import java.net.*;

class Cryptography_C
{
	public static void main(String args[])throws IOException
	{
		try
		{

					   Socket s=new Socket("192.168.43.183",6666);

					   BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));    // returns object of DataOutputStream to be encapsulated in OutputStreamWriter to be encapsulated in BufferedWriter
					   BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));	  // returns object of DataInputStream to be encapsulated in InputStreamReaderto be encapsulated in BufferedReader
					   BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));

						System.out.println("Enter data to encrypt");
						String inp=buf.readLine();

						bw.write(inp);
						bw.newLine();
			            bw.flush();

						String encrypt=br.readLine();

						System.out.println(" Encypted data " + encrypt);

						bw.write(encrypt);
						bw.newLine();
			            bw.flush();

			           bw.close();
			           s.close();

		 }

		catch(Exception e)
		{
			System.out.println("This is a mess !");
		}
	}
}
