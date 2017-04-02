import java.io.*;
//#define FLAG '@'
//#define ESC '*'
class ByteStuff
{
char msg[]=new char[20];
char actualmsg[]=new char[20];
char data[]=new char[20];;
char FLAG='@';
char ESC='*';
int k=0;
void sender()throws IOException
{
   BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
    int i,j=1,len;
    System.out.println("Use @ as FLAG character and * as ESC character");
    System.out.println("\nEnter the length of the message\n");
    len=Integer.parseInt(b.readLine());
    System.out.println("\nEnter the message\n");
    for(i=0;i<len;i++)
    data[i]=(char)b.read();
    msg[0]=FLAG;
    for(i=0;i<len;i++)
    {
        if(data[i]==FLAG || data[i]==ESC)
        	msg[j++]=ESC;

        msg[j++]=data[i];

    }
    msg[j++]=FLAG;
    msg[j]='\0';
    k=j;
   System.out.println("\n\nThe message is sent as: ");
for(i=0;i<j;i++)
{
System.out.print(msg[i]);
}
}

void receiver()
{
	int i=1,j=0,n=0;
	System.out.println("\n\nThe received message is: ");
for(n=0;n<k;n++)
{
System.out.print(msg[n]);
}

	while(msg[i+1]!='\0')
	{
		if(msg[i]==ESC)
			i++;
		actualmsg[j]=msg[i];
		i++;
		j++;
	}
	actualmsg[j]='\0';
	System.out.println("\n\nThe message after de-stuffing is:");
	for(n=0;n<j;n++)
	{
	 System.out.print(actualmsg[n]);
	}
}

public static void main(String args[])throws IOException
{
 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
   ByteStuff bs=new ByteStuff();
   int a=0;
   do
   {
     System.out.println("\n\nEnter 1-To Send\nEnter 2-To Receive\n");
   	 a=Integer.parseInt(br.readLine());
	   switch(a)
         {
         	case 1: bs.sender();
            		break;
             case 2: bs.receiver();
           		break;
         }

   } while(a!=0);

}

}