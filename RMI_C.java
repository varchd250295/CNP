import java.rmi.*;
public class RMI_C
{
    public static void main(String args[])
    {
        String value="Varun";
        int answer=0;

        try
        {
            Length access =
                (Length)Naming.lookup("rmi://localhost:6666"+
                                      "/Varun");
            answer = access.length(value);
            System.out.println("Length of " + value + "=" + answer);
        }
        catch(Exception ae)
        {
            System.out.println(ae);
        }
    }
}