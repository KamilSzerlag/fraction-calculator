package polsl.jium.kszerlag;

import polsl.jium.kszerlag.server.AppServer;

/**
 * Class contains main method for server side fraction calculator application.
 *
 * @author Kamil Szerląg
 * @version 1.0
 */
public class FractionCalculatorApp {

    /**
     * Main method which starting server.
     * The server is created immediately after starting the application.
     * 
     * @param args no arguments are needed. 
     */
    public static void main(String[] args) {
        AppServer server = new AppServer();
        server.createServerSocket();
    }
    
}
