// DELIMITER = 01111110

import java.io.*;
import java.net.*;
import java.util.*;

class bitstuffing_S
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

			String inp=br.readLine();
			System.out.println(" Client Sent : " + inp);

			String out="";

              int counter=0;

            for(int i=8;i<inp.length()-8;i++)
                {

                    if(inp.charAt(i) == '1')
                        {

                            counter++;
                            out = out + inp.charAt(i);

                        }
                    else
                        {
                             out = out + inp.charAt(i);
                             counter = 0;
                        }
                   if(counter == 5)
                        {
                              if((i+2)!=inp.length())
                              out = out + inp.charAt(i+2);
                              else
                              out=out + '1';
                              i=i+2;
                              counter = 1;
                        }
               }


             System.out.println("Original Message : "+out);

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
