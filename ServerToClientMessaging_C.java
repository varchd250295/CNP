import java.io.*;
import java.net.*;

class ServerToClientMessaging_C
{
	public static void main(String args[])
	{

		int port;
		String ip,str;
		Socket socket;
		String outMessage;


		//port=Integer.parseInt(args[1]);
		//ip=args[0];

		port=8080;
		ip="127.0.0.1";



		try
		{

			socket=new Socket(ip,port);
			System.out.println("Connected to Server : "+socket.getRemoteSocketAddress());

			BufferedReader xxx=new BufferedReader(new InputStreamReader(socket.getInputStream()));

			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));

			while(true)
			{
				str=xxx.readLine();

				if(!str.equalsIgnoreCase("STOP"))
					System.out.println(str);
				else
					{
						System.exit(0);
						socket.close();

					}

				outMessage=buf.readLine();
				if(!outMessage.equalsIgnoreCase("STOP"))
					{
						bw.write(outMessage);
						bw.newLine();
						bw.flush();
					}
				else
					{
						System.exit(0);
						socket.close();

					}


			}

		}

		catch(IOException e)
		{
			System.out.println("IOException occurred!");
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();

		}

	}
}



