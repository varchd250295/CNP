import java.io.*;
import java.net.*;

class ServerToClientMessaging_S
{
	public static void main(String args[])
		{
			ServerSocket serverSocket;
			Socket socket;
			String outMessage;

			//listenPort=Integer.parseInt(args[0]);
			int listenPort=8080;
			
			String str="";

			try
			{
				while(true)
				{

					serverSocket=new ServerSocket(listenPort);

					System.out.println("Listening to port : "+ listenPort);

					socket=serverSocket.accept();

					System.out.println("Connected to client :"+socket.getRemoteSocketAddress());


					BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

					BufferedReader xx=new BufferedReader(new InputStreamReader(System.in));
					BufferedReader buf=new BufferedReader(new InputStreamReader(socket.getInputStream()));

					System.out.println("Say what you wanna say! (Type 'So Long Sucker' (not case sensitive) or just 'goodbye' to disconnect))");
					
					while(true)
					{
					
						outMessage=xx.readLine();
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
								serverSocket.close();
							}

						str=buf.readLine();

						if(!str.equalsIgnoreCase("STOP"))
							System.out.println(str);
						else
							{
								System.exit(0);
								socket.close();
								serverSocket.close();
							}
					}

				}




			}

	
			catch(IOException e)
			{
				System.out.println("IOException occurred!");
				e.printStackTrace();
			}
		}

	}

