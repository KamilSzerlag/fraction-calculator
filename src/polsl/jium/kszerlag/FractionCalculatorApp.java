package polsl.jium.kszerlag;

import polsl.jium.kszerlag.server.FractionServer;

/**
 * FractionCalculatorApp helps performing operations on mathematics fraction.
 * Input expression for example like "2/1+3/5" will be calculated 
 * and displayed in calculator window text field.
 * 
 * Actually basic arithmetic operations are supported.
 * 
 * Application using MVC patter for communications between logic and visual layer. 
 *
 * @author Kamil Szeląg
 * @version 1.0
 */
public class FractionCalculatorApp {

    /**
     * @param args  
     */
    public static void main(String[] args) {
        FractionServer server = new FractionServer();
        server.createServerSocket();
    }
    
}
