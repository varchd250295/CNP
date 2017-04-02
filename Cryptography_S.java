import java.io.*;
import java.security.*;
import javax.crypto.*;
import java.net.*;

class Cryptography_S
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


			  char[] toCode;
			   byte[] toCode2;
			   byte[] Coded;
			   char[] Coded2;




			   String toMake = br.readLine();


			   KeyGenerator keyGen = KeyGenerator.getInstance("AES");
			   SecretKey aesKey = keyGen.generateKey();


			   Cipher aesCipher = Cipher.getInstance("AES");


			   aesCipher.init(Cipher.ENCRYPT_MODE, aesKey);
			   System.out.println("The Key : " + aesKey.getEncoded());

			   toCode = toMake.toCharArray();
			   toCode2 = new byte[toCode.length];
			   Coded = new byte[toCode.length];
			   for(int i=0;i<toCode.length;i++)
				   toCode2[i] = (byte)toCode[i];


			   Coded = aesCipher.doFinal(toCode2);


			   Coded2 = new char[Coded.length];
			   for(int i=0;i<Coded.length;i++)
				   Coded2[i] = (char)Coded[i];
	System.out.println("Test Encrypt: " + new String(Coded2));

			bw.write(new String(Coded2));
			bw.newLine();
			bw.flush();

// DECRYPT
		   byte[] decoded;
		   char[] deco2;



		  Cipher aesCipher2 = Cipher.getInstance("AES");


		   aesCipher2.init(Cipher.DECRYPT_MODE, aesKey);

		   decoded = aesCipher2.doFinal(Coded);


		   deco2 = new char[decoded.length];
		   for(int i=0;i<decoded.length;i++)
			   deco2[i] = (char)decoded[i];

		   System.out.println("Test Decrypt: " + new String(deco2));
		   }

		   catch(Exception e)
		   {
					System.out.println("This is a mess !");
		   }
	}
}
