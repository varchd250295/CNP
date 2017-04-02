//DELIMITER = 01111110


import java.io.*;
import java.net.*;

public class bitstuffing_C
{
       public static void main(String[] args)throws IOException
       {
		   try
		   {

			   Socket s=new Socket("localhost",6666);

			   BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));    // returns object of DataOutputStream to be encapsulated in OutputStreamWriter to be encapsulated in BufferedWriter
			   BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));	  // returns object of DataInputStream to be encapsulated in InputStreamReaderto be encapsulated in BufferedReader
			   BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));


			  System.out.print("Binary message: ");
			  String msg=buf.readLine();


			  String res = new String();
			  String out=new String();

			  int counter = 0;
			  for(int i=0;i<msg.length();i++)
				{

				   if (msg.charAt(i)!='1' && msg.charAt(i)!='0')
						{
							System.out.println("Enter only Binary values!!!");
							return;
						}
				   if(msg.charAt(i) == '1')
						{
							counter++;
							res = res + msg.charAt(i);
						}
				   else
						{
							res = res + msg.charAt(i);
							counter = 0;
						}
				   if(counter == 5)
						{
							res = res + '0';
							counter = 0;
						}
				}

			String fmsg="01111110"+res+"01111110";

			bw.write(fmsg);
			bw.newLine();
			bw.flush();
		}

		catch(Exception e)
		{
					System.out.println(" Nigga, you fucked up ! ");
		}

	}
}