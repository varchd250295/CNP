import java.io.*;
import java.net.*;
class Hamming
{
	public static void main(String args[])
	{

		Socket s=new Socket("localhost",6666);

		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));    // returns object of DataOutputStream to be encapsulated in OutputStreamWriter to be encapsulated in BufferedWriter
		BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));	  // returns object of DataInputStream to be encapsulated in InputStreamReaderto be encapsulated in BufferedReader
		BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter the number of bits for the Hamming code:");
		int n = Integer.parseInt(buf.readLine());
		int a[] = new int[n];

		for(int i=0 ; i < n ; i++)
		{
			System.out.println("Enter bit no. " + (n-i) + ":");
			a[n-i-1] = scan.nextInt();
		}

		System.out.println("You entered:");
		for(int i=0 ; i < n ; i++) {
			System.out.print(a[n-i-1]);
		}
		System.out.println();

		int b[] = generateCode(a);

		System.out.println("Generated code is:");
		for(int i=0 ; i < b.length ; i++) {
			System.out.print(b[b.length-i-1]);
		}
		System.out.println();

		// Difference in the sizes of original and new array will give us the number of parity bits added.
		System.out.println("Enter position of a bit to alter to check for error detection at the receiver end (0 for no error):");
		int error = scan.nextInt();
		if(error != 0) {
			b[error-1] = (b[error-1]+1)%2;
		}
		System.out.println("Sent code is:");
		for(int i=0 ; i < b.length ; i++) {
			System.out.print(b[b.length-i-1]);
		}
		System.out.println();
		receive(b, b.length - a.length);
	}

	static int[] generateCode(int a[]) {
		// We will return the array 'b'.
		int b[];

		// We find the number of parity bits required:
		int i=0, parity_count=0 ,j=0, k=0;
		while(i < a.length) {
			// 2^(parity bits) must equal the current position
			// Current position is (number of bits traversed + number of parity bits + 1).
			// +1 is needed since array indices start from 0 whereas we need to start from 1.

			if(Math.pow(2,parity_count) == i+parity_count + 1) {
				parity_count++;
			}
			else {
				i++;
			}
		}

		// Length of 'b' is length of original data (a) + number of parity bits.
		b = new int[a.length + parity_count];

		// Initialize this array with '2' to indicate an 'unset' value in parity bit locations:

		for(i=1 ; i <= b.length ; i++) {
			if(Math.pow(2, j) == i) {
			// Found a parity bit location.
			// Adjusting with (-1) to account for array indices starting from 0 instead of 1.

				b[i-1] = 2;
				j++;
			}
			else {
				b[k+j] = a[k++];
			}
		}
		for(i=0 ; i < parity_count ; i++) {
			// Setting even parity bits at parity bit locations:

			b[((int) Math.pow(2, i))-1] = getParity(b, i);
		}
		return b;
	}

	static int getParity(int b[], int power) {
		int parity = 0;
		for(int i=0 ; i < b.length ; i++) {
			if(b[i] != 2) {
				// If 'i' doesn't contain an unset value,
				// We will save that index value in k, increase it by 1,
				// Then we convert it into binary:

				int k = i+1;
				String s = Integer.toBinaryString(k);

				//Nw if the bit at the 2^(power) location of the binary value of index is 1
				//Then we need to check the value stored at that location.
				//Checking if that value is 1 or 0, we will calculate the parity value.

				int x = ((Integer.parseInt(s))/((int) Math.pow(10, power)))%10;
				if(x == 1) {
					if(b[i] == 1) {
						parity = (parity+1)%2;
					}
				}
			}
		}
		return parity;
	}




























class Hamming_C
{
	public static void main(String args[])throws IOException
	{
		try
		{

			Socket s=new Socket("localhost",6666);

			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));    // returns object of DataOutputStream to be encapsulated in OutputStreamWriter to be encapsulated in BufferedWriter
			BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));	  // returns object of DataInputStream to be encapsulated in InputStreamReaderto be encapsulated in BufferedReader
			BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));

			String Cstr,Sstr="";

			System.out.println(" String to Reverse : ");
			Cstr=buf.readLine();

			bw.write(Cstr);
			bw.newLine();
			bw.flush();

			Sstr=br.readLine();
			System.out.println(" Server Reversed : " + Sstr);

			bw.flush();
			bw.close();
			s.close();

		}

		catch(Exception e)
		{
			System.out.println(" Nigga, you fucked up ! ");
		}

	}
}