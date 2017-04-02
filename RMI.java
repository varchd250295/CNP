import java.rmi.*;
import java.rmi.server.*;
public class RMI extends UnicastRemoteObject
                         implements Length
{
    // Default constructor to throw RemoteException
    // from its parent constructor
    RMI() throws RemoteException
    {
        super();
    }

    // Implementation of the query interface
    public int length(String inp)
                       throws RemoteException
    {
        return (inp.length());
    }
}