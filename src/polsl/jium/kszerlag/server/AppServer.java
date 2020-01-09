package polsl.jium.kszerlag.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server class, contains methods to create and handle 
 * connection via TCP protocol.
 * 
 * @version 1.0
 * @author Kamil Szerląg
 */
public class AppServer {
    
    /**
     * Port which will be reserved for created server.
     */
    private int port = 8080;
    
    /**
     * Constructor initializing port value from properties file. 
     */
    public AppServer() {
        PropertiesHelper propertiesHelper = new PropertiesHelper();
        String port = propertiesHelper.getProperty("port");
        if (port != null) {
            this.port = Integer.valueOf(port);
        }
    }
    
    /**
     * Method creating server socket. 
     * Connection is handling as long as response from the client is different then
     * null or value in the message is not equal to "BYE". 
     * 
     */
    public void createServerSocket() {
        try (
            ServerSocket serverSocket = new ServerSocket(port);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ) {
            String inputLine; 
            String outputLine;
            
            SimpleProtocol fprotocol = new SimpleProtocol();
            outputLine = fprotocol.processInput(null);
            out.println(outputLine);
            while((inputLine = in.readLine()) != null) {
                outputLine = fprotocol.processInput(inputLine);
                out.println(outputLine);
                if (outputLine.contains("BYE")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
