/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polsl.jium.kszerlag.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author szerlag
 */
public class FractionServer {

    private int port = 8080;
    
    public FractionServer() {
    }
    
    
    public void createServerSocket() {
        try (
                ServerSocket serverSocket = new ServerSocket(port);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ) {
            String inputLine; 
            String outputLine;
            
            FractionProtocol fprotocol = new FractionProtocol();
            outputLine = fprotocol.processInput(null);
            out.println(outputLine);
            System.out.println(outputLine);
            
            while((inputLine = in.readLine()) != null) {
                outputLine = fprotocol.processInput(inputLine);
                out.println(outputLine);
                if (outputLine.equals("BYE")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
