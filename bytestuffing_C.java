// FLAG = 01111110 ; ESC = 01010101

import java.io.*;
import java.net.*;

public class bytestuffing_C
{
       public static void main(String[] args)throws IOException
       {
		   try
		   {

			   Socket s=new Socket("localhost",6666);

			   BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));    // returns object of DataOutputStream to be encapsulated in OutputStreamWriter to be encapsulated in BufferedWriter
			   BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));	  // returns object of DataInputStream to be encapsulated in InputStreamReaderto be encapsulated in BufferedReader
			   BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));

			String FLAG="01111110";
			String ESC="01010101";

	//	System.out.println("\nEnter the message\n");
	//	String msg=buf.readLine();

	String msg="0111111000001010101";



			String fmsg=FLAG;

			for(int i=0;i<msg.length();i++)
			{



				if(msg.substring(i,i+8).equals(FLAG) || msg.substring(i,i+8).equals(ESC))
				{
					fmsg+=ESC+msg.substring(i,i+8);
					i+=7;
					continue;
				}

				fmsg+=msg.charAt(i);

			}

			fmsg+=FLAG;

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