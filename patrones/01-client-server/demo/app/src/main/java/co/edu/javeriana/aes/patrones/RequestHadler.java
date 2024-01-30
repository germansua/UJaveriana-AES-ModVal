package co.edu.javeriana.aes.patrones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author German Suárez - german.suarez@javeriana.edu.co
 */
public class RequestHadler implements Runnable {
    
    private final Socket clientSocket;
    private final String responseHeaderRaw = """
        HTTP/1.1 200 OK
        Content-Type: text/html
        Content-Length: %d

        """;
    private byte[] content = "<h1>It works!</h1>".getBytes();

    public RequestHadler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
    
    @Override
    public void run()  {
        try (var reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                var output = clientSocket.getOutputStream()) {
            reader.lines().limit(4).forEach(System.out::println);
            var responseHeader = responseHeaderRaw.formatted(content.length).getBytes();
            output.write(responseHeader);
            output.write(content);
            output.flush();
        } catch (IOException ex) {
            System.out.println("RequestHadler -> Something went wrong: " + ex);
        } finally {
            try {
                clientSocket.close();
                System.out.println("Client socket closed");
            } catch (IOException ex) {
                System.out.println("RequestHadler.run -> Someting wrong closing the client socket");
            }
        }
    }
}
