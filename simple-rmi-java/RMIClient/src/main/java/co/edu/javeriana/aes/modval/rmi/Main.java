package co.edu.javeriana.aes.modval.rmi;

import java.rmi.Naming;

public class Main {

    public static void main(String[] args) throws Exception {
        EchoServer remoteService =
                (EchoServer) Naming.lookup("rmi://java-rmi-server:7875/EchoService");
        while (true) {
            remoteService.echo("Hello World at " + System.currentTimeMillis());
            try {
                Thread.sleep(1500);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }
}
