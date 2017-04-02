// DLE STX ; DLE ETX ; DLE DLE

import java.io.*;
import java.net.*;

public class charstuffing_C
{
       public static void main(String[] args)throws IOException
       {
		   try
		   {

			   Socket s=new Socket("localhost",6666);

			   BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));    // returns object of DataOutputStream to be encapsulated in OutputStreamWriter to be encapsulated in BufferedWriter
			   BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));	  // returns object of DataInputStream to be encapsulated in InputStreamReaderto be encapsulated in BufferedReader
			   BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));


	//	System.out.println("\nEnter the message\n");
	//	String msg=buf.readLine();

	String msg="A B DLE D E DLE";



			String fmsg="DLESTX ";

			for(int i=0;i<msg.length();i++)
			{



				if(msg.substring(i,i+3).equals("DLE"))
				{
					fmsg+="DLE"+msg.substring(i,i+3);
					i+=2;
					continue;
				}

				fmsg+=msg.charAt(i);

			}

			fmsg+=" DLEEXT";

			System.out.println("\n\n Sent Message: " + fmsg);


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