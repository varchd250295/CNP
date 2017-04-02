// Test for Image, Video, Audio, DLL

import java.io.*;
import java.net.*;
import java.util.*;

public class FTP_C
{
       public static void main(String[] args)throws IOException
       {
		   try
		   {

			   Socket s=new Socket("localhost",6666);

			   BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));    // returns object of DataOutputStream to be encapsulated in OutputStreamWriter to be encapsulated in BufferedWriter
			   BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));	  // returns object of DataInputStream to be encapsulated in InputStreamReaderto be encapsulated in BufferedReader
			   BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));


			  System.out.print("File name: ");
			  String name=buf.readLine();

			  System.out.print("Directory: ");
			  String directory=buf.readLine();


			bw.write(name);
			bw.newLine();
			bw.flush();

			bw.write(directory);
			bw.newLine();
			bw.flush();

     byte[] contents = new byte[10000];


        FileOutputStream fos = new FileOutputStream("C:\\Users\\Asus\\Documents\\test2.txt");

        BufferedOutputStream bos = new BufferedOutputStream(fos);
        InputStream is = s.getInputStream();


        int bytesRead = 0;

        while((bytesRead=is.read(contents))!=-1)
            bos.write(contents, 0, bytesRead);

        bos.flush();

			bw.close();
			s.close();

			System.out.println(" SUCCESS ! Check = " + "C:\\Users\\Asus\\Documents");

		}

		catch(Exception e)
		{
					System.out.println(" Nigga, you fucked up ! ");
		}

	}
}