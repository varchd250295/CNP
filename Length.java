import java.rmi.*;
public interface Length extends Remote
{

    public int length(String inp) throws RemoteException;
}