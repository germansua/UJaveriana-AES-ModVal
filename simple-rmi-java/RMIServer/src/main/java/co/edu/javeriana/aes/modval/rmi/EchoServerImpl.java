package co.edu.javeriana.aes.modval.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Logger;

public class EchoServerImpl extends UnicastRemoteObject implements EchoServer {

    public static Logger logger = Logger.getLogger("EchoService");

    public EchoServerImpl() throws RemoteException {
    }

    @Override
    public String echo(String toEcho) throws RemoteException {
        String response = String.format("Response from server: Client request -> \"%s\", Server Timestamp -> %d", toEcho, System.currentTimeMillis());
        logger.info(response);
        return response;
    }
}
