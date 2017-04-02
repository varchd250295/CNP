
import java.rmi.*;
import java.rmi.registry.*;
public class RMI_S
{
    public static void main(String args[])
    {
        try
        {

            Length obj = new RMILength();


            LocateRegistry.createRegistry(6666);


            Naming.rebind("rmi://localhost:6666"+
                          "/Varun",obj);
        }
        catch(Exception ae)
        {
            System.out.println(ae);
        }
    }
}