import java.io.*;
import java.net.*;
import java.util.*;

class charstuffing_S
{
	public static void main(String args[])throws IOException
	{
		try
		{

			ServerSocket ss=new ServerSocket(6666);
			Socket s=ss.accept();						// establishes connection

			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));    // returns object of DataOutputStream to be encapsulated in OutputStreamWriter to be encapsulated in BufferedWriter
			BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));	  // returns object of DataInputStream to be encapsulated in InputStreamReaderto be encapsulated in BufferedReader
			BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));

			String FLAG="01111110";
			String ESC="01010101";

			String inp=br.readLine();
			String out="";

			System.out.println(" Client Sent : " + inp);

			for(int i=6;i<inp.length()-6;i++)
			{

				if(inp.substring(i,i+3).equals("DLE"))
				{
						out+=inp.substring(i+3,i+6);
						i+=5;
						continue;
				}

				out+=inp.charAt(i);
			}


			System.out.println("\n\nOriginal Message :" + out);


            bw.flush();
			bw.close();
			s.close();
			ss.close();

		 }

		 catch(Exception e)
		 {
		 					System.out.println(" Nigga, you fucked up ! ");
		 }
	 }
 }
