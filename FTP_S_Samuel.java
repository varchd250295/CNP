import java.io.*;
import java.net.*;
import java.util.*;


class FTP_S_Samuel

{
	public static void main(String args[])
	{
		ServerSocket serverSocket;
		Socket socket;

		int port=8080;

		String ip;

		if(args.length==0)ip="127.0.0.1";
		else
		ip=args[0];



		while(true)
		{
			try
			{
				serverSocket=new ServerSocket(port);
				serverSocket.setSoTimeout(20000);


				System.out.println("Listening to port : "+port);
				socket=serverSocket.accept();

				System.out.println("Connected to : "+ socket.getRemoteSocketAddress());

				BufferedReader xxx=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

				String fl=xxx.readLine();

				//System.out.println(fl);
				//xxx.readLine();

				File file=new File("C:\\Users\\Samuel\\Documents\\CNP Lab\\Input\\"+fl);

				if(!file.exists())
				{
					bw.write("_|_");
					bw.newLine();
					bw.flush();

					continue;
				}


				InputStream in=new FileInputStream(file);
				OutputStream out=socket.getOutputStream();

				bw.write("____");
				bw.newLine();
				bw.flush();

				byte[] b=new byte[102400];

				int count;
				while ((count = in.read(b)) > 0)
				{
					out.write(b, 0, count);
				}

				in.close();
				out.close();
				serverSocket.close();

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
}
