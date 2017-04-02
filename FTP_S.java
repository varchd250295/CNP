import java.io.*;
import java.util.*;
import java.net.*;

class FTP_S
{
	public static String path="";

	public void findFile(String name,File file)
	{
		File[] list = file.listFiles();

		if(list!=null)
			for (File fil : list)
			{
				 if (fil.isDirectory())
					findFile(name,fil);
				 else
					if (name.equalsIgnoreCase(fil.getName()))
					{

					   path=""+fil.getParentFile();
					}
			}
	 }

     public static void main(String[] args)
    {
    	try
		{

			ServerSocket ss=new ServerSocket(6666);
			Socket s=ss.accept();						// establishes connection

			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));    // returns object of DataOutputStream to be encapsulated in OutputStreamWriter to be encapsulated in BufferedWriter
			BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));	  // returns object of DataInputStream to be encapsulated in InputStreamReaderto be encapsulated in BufferedReader
		    BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));

			String name = br.readLine();
			String directory = br.readLine();
			String dir="";

			FTP_S obj=new FTP_S();
			obj.findFile(name,new File(directory));

		    System.out.println(path);

		    path=path + "\\" + name;
		    System.out.println(path);

		    for(int i=0;i<path.length();i++)
		    	if(path.charAt(i)=='\\')
		    		dir+="\\\\";
		    	else
		    		dir+=path.charAt(i);

		    System.out.println(dir);


			File file = new File(dir);

			        FileInputStream fis = new FileInputStream(file);
			        BufferedInputStream bis = new BufferedInputStream(fis);


			        OutputStream os = s.getOutputStream();


			        byte[] contents;
			        long fileLength = file.length();
			        long current = 0;

			           while(current!=fileLength)
			           {
			             int size = 10000;

			           if(fileLength - current >= size)
			                current += size;
			            else{
			                size = (int)(fileLength - current);
			                current = fileLength;
			            }


			            contents = new byte[size];
			            bis.read(contents, 0, size);
			            os.write(contents);




		}
		s.close();
        ss.close();

         System.out.println("File sent. Check client specified destination.");

	}

		catch(Exception e)
		{
			System.out.println("This is a mess !");
        }

    }
}