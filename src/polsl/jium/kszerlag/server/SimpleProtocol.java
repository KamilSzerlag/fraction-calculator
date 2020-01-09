package polsl.jium.kszerlag.server;

import java.util.Arrays;
import java.util.List;
import polsl.jium.kszerlag.model.arithmetic.fraction.Fraction;
import polsl.jium.kszerlag.model.arithmetic.fraction.FractionArithmeticException;
import polsl.jium.kszerlag.model.evaluator.EvaluationExpressionException;
import polsl.jium.kszerlag.model.evaluator.SimpleFractionExpressionEvaluator;

/**
 * Provides protocol for communication between server and client.
 * Available commands:
 * <b>HELP</b> - printing commads supported by server
 * <b>CALC</b> - calculating expression and returning result
 * <b>QUIT</b> - stoping server running
 * 
 * RETURNED STATUSES:
 * 100 - Connected, when client is create connection to server
 * 200 - ACCEPTED, when request was correct
 * 300 - BAD REQUEST, when request was incorrect
 * 500 - CONNECTION END, when connection is closed. 
 * @version 1.0
 * @author Kamil Szerląg
 */
public class SimpleProtocol {
    
    /**
     * <b>HELP</b> - printing commads supported by server
     */
    private final String HELP = "HELP";
    /**
     * <b>CALC</b> - calculating expression and returning result
     */
    private final String CALC = "CALC";
    /**
     * <b>QUIT</b> - stopping server running
     */
    private final String QUIT = "QUIT";
    
    /**
     * After creating connection this flag is set. Contains information that server
     * is ready to recive messages.
     */
    private final String REDY = "REDY";
    
    /**
     * 100 - Connected, when client is create connection to server
     */
    private final String CONNECTED = "100 Connected";
    
    /**
     * 200 - ACCEPTED, when request was correct
     */
    private final String ACCEPTED = "200 Accepted";
    /**
     * 300 - BAD REQUEST, when request was incorrect
     */
    private final String BAD_REQUEST = "300 Bad request";
    /**
     * CONNECTION END, when connection is closed. 
     */
    private final String CONNECTION_END = "500 Connection end";
    
    /**
     * Array contains commands supported by this protocol
     */
    private List<String> commands = Arrays.asList(HELP, CALC, QUIT, REDY);
    
    /**
     * Actual Statement - After creating connection is setting to REDY  
     */
    private String state = REDY;
    
    /**
     * Evaluator calculating expression.
     */
    SimpleFractionExpressionEvaluator fractionExpressionEvaluator = new SimpleFractionExpressionEvaluator();
    
    /**
     * Processing retrived request from client, which should contains 
     * command or command and expression.
     * For example:
     * HELP
     * CALC 1/2+1/2
     * 
     * @param input Value of the input to processing
     * @return output containing response for the client
     */
    String processInput(String input) {
        String output = null;
        String[] inputArray = parseInput(input);
        state = inputArray[0] != null ? inputArray[0] : REDY;
        if (state.equals(REDY)) {
            return formatMessage(CONNECTED, "Server ready!");
        }
        if (!isValid(inputArray)) {
            return formatMessage(BAD_REQUEST, "Invalid command format!");
        }
        if (!commands.contains(state)) {
            return formatMessage(BAD_REQUEST, "Command unrecognized!");
        }
        if (state.equals(CALC)) {
            try {
                Fraction expResult = fractionExpressionEvaluator.eval(inputArray[1]);
                return formatMessage(ACCEPTED, expResult.toString());
            } catch (EvaluationExpressionException | FractionArithmeticException e) {
                return formatMessage(BAD_REQUEST, e.getMessage());
            }
        }
        if (state.equals(HELP)) {
            return "ACCEPTED COMMANDS: HELP, CALC expression, QUIT";
        }
        if (state.equals(QUIT)) {
            return formatMessage(CONNECTION_END, "BYE");
        }
        return output;
    }
    
    /**
     * Parsing input to required format
     * 
     * @param input Value of the input to processing
     * @return Array with splited elements of request
     */
    private String[] parseInput(String input) {
        if (input != null) {
            return input.split(" ");
        }
        return new String[1];
    }
    
    /**
     * Checking whether request is valid
     * 
     * @param input Value of the input to processing
     * @return true if request is valid else false
     */
    public boolean isValid(String[] input) {
        return input.length <= 2;
    }
    
    /**
     * Formating message sended by server
     *  
     * @param code protocol codes with information about request processing status
     * @param msg message to send to client
     * @return formated message example: 100 Accepted 1/2 
     */
    private String formatMessage(String code, String msg) {
        return String.format("CODE: %s %s", code, msg);
    }
}
