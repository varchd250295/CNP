import java.io.*;
import java.net.*;
import java.util.*;

class FTP_C_Samuel
{
	public static void main(String args[])
	{
		Socket socket;
		int port;
		String ip;

		if(args.length==0 || args.length==1)   // command line input for connection taken as <Server IP><space><port number>  (ALL OPTIONAL(localhost and port -8080 assumed if unspecified))
		port=8080;
		else port=Integer.parseInt(args[1]);

		if(args.length==0)
		ip="192.168.43.71";
		else
		ip=args[0];


		try
		{

			socket=new Socket(ip,port);
			System.out.printf("Connected to :"+socket.getRemoteSocketAddress());

			BufferedReader xxx=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			BufferedReader xx=new BufferedReader(new InputStreamReader(System.in));

			System.out.println("\n\nEnter the name of the file to be searched for: ");

			String fl=xx.readLine();

			bw.write(fl);
			bw.newLine();
			bw.flush();


			String temp=xxx.readLine();

			if(temp.equals("_|_"))
			{
				System.out.println("No such file exists! Try again!");
				System.exit(0);
			}

			OutputStream out=new FileOutputStream("C:\\Users\\Samuel\\Documents\\CNP Lab\\Output\\"+fl);
			InputStream in=socket.getInputStream();


			byte[] b=new byte[102400];

			int count;
			while ((count = in.read(b)) > 0)
			{
				out.write(b, 0, count);
			}

			System.out.println("\"Great Success!\"-Borat");

			out.close();

		}
		catch(SocketTimeoutException e)
		{
			System.out.println("Server timed out due to inactivity! Run it again!");
			System.exit(0);
		}
		catch(IOException e)
		{
			System.out.println("I/O Exception Occurred!");
			e.printStackTrace();
		}

	}

}