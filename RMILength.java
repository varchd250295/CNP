import java.rmi.*;
import java.rmi.server.*;
public class RMILength extends UnicastRemoteObject
                         implements Length
{

    RMILength() throws RemoteException
    {
        super();
    }


    public int length(String inp)
                       throws RemoteException
    {
        return (inp.length());
    }
}