package co.edu.javeriana.aes.patrones;

import java.net.ServerSocket;
import java.util.concurrent.Executors;

/**
 * @author German Suárez - german.suarez@javeriana.edu.co
 */
public class SimpleHttpServer extends Thread {

    private final int bindingPort = 8080;
    private final int maxThreads = 5;

    @Override
    public void run() {
        startServer();
    }

    private void startServer() {
        var executor = Executors.newFixedThreadPool(maxThreads);

        try (var serverSocket = new ServerSocket(bindingPort)) {
            System.out.println("Simple Http Server listening on port: " + bindingPort);

            while (true) {
                var clientSocket = serverSocket.accept();
                executor.submit(new RequestHadler(clientSocket));
            }
        } catch (Exception ex) {
            System.out.println("SimpleHttpServer -> Something went wrong: " + ex);
        }
    }
}