package co.edu.javeriana.aes.modval.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EchoServer extends Remote {

    String echo(String toEcho) throws RemoteException;
}
