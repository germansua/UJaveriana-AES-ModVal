package co.edu.javeriana.aes.modval.rmi;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Logger;

public class Main {

    public static Logger logger = Logger.getLogger("EchoService");

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {

        logger.info("Creating registry...");

        Registry registry = LocateRegistry.createRegistry(7875);

        logger.info("Registry created");
        logger.info("Binding the EchoService");

        registry.bind("EchoService", new EchoServerImpl());

        logger.info("EchoService ready...");

    }
}
