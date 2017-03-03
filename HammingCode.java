import java.io.*;
import java.util.*;

class HammingCode
{

    public static void main(String args[])throws IOException
    {
        BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));

        System.out.println("DataWord Size");
        int n = Integer.parseInt(buf.readLine());

        System.out.println("DataWord (starting from left to right)");
        int data[] = new int[n + 1];

        for (int i = 1; i <= n; i++)
        {
            data[i] = Integer.parseInt(buf.readLine());
        }

        int k = 1;
        int m = n + (int) Math.ceil(Math.log10(n) / Math.log10(2)) + 1;
        int code[] = new int[m + 1];

        for (int i = 1; i <= m; i++)
        {
            if (Math.ceil(Math.log10(i) / Math.log10(2)) == Math.floor(Math.log10(i) / Math.log10(2)))
            {
                code[i] = 0;
            }
            else
            {
                code[i] = data[k++];
            }
        }

        String print = "";

        for (int i = 1; i <= m; i++)
        {
            print = print + code[i];
        }

        System.out.println(print);

        for (int i = 1; i <= m; i *= 2)
        {
            int val = 0;

            for (int p = i; p <= m; p += i)
            {
                int count = i;
                while (count != 0 && p <= m)
                {
                    val ^= code[p++];
                    count--;
                }

            }

            code[i] = val;
            System.out.println("Parity Bit at " + i + " is : " + code[i]);
        }

        System.out.println("");

        for (int j = 1; j <= m; j++)
        {
            System.out.print(code[j]);
        }

        System.out.println("");

        System.out.println("CodeWord :" + print);

        code[6] = 0;
        int e = 0;

        for (int i = 1; i <= m; i *= 2)
        {
            int val = 0;

            for (int p = i; p <= m; p += i)
            {
                int count = i;
                while (count != 0 && p <= m)
                {
                    val ^= code[p++];
                    count--;
                }
            }

            if (val == 1)
            {
                e = e + i;
                System.out.println("ERROR. Parity bit position = " + i);
            }
        }

        System.out.println("ERROR. Position " + e);

        if (code[e] == 0)
        {
            code[e] = 1;
        }

        else
        {
            code[e] = 0;
        }

        for (int j = 1; j <= m; j++)
        {
            System.out.print(code[j]);
        }
        System.out.println("");
    }
}