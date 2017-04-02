import java.rmi.*;
public interface Length extends Remote
{
    // Declaring the method prototype
    public int length(String inp) throws RemoteException;
}