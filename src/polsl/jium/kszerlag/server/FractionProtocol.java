/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polsl.jium.kszerlag.server;

import java.util.Arrays;
import java.util.List;
import polsl.jium.kszerlag.model.arithmetic.fraction.Fraction;
import polsl.jium.kszerlag.model.arithmetic.fraction.FractionArithmeticException;
import polsl.jium.kszerlag.model.evaluator.EvaluationExpressionException;
import polsl.jium.kszerlag.model.evaluator.SimpleFractionExpressionEvaluator;

/**
 *
 * @author szerlag
 */
public class FractionProtocol {
    private final String HELP = "HELP";
    private final String CALC = "CALC";
    private final String QUIT = "QUIT";
    private final String WAIT = "WAIT";
    
    private final String CONNECTED = "100 Connected";
    private final String ACCEPTED = "200 Accepted";
    private final String BAD_REQUEST = "300 Bad request";
    private final String CONNECTION_END = "500 Connection end";
    
    private List<String> commands = Arrays.asList(HELP, CALC, QUIT, WAIT);
    
    private String state = WAIT;
    
    public String processInput(String input) {
        String output = null;
        String[] inputArray = parseInput(input);
        state = inputArray[0] != null ? inputArray[0] : WAIT;
        if (state.equals(WAIT)) {
            return serverMessage(CONNECTED, "Server ready!");
        }
        if (!isValid(inputArray)) {
            output = BAD_REQUEST + " Invalid command format!";
        }
        if (!commands.contains(input)) {
            output = "Command unrecognized!";
        }
        if (state.equals(CALC)) {
            try {
                SimpleFractionExpressionEvaluator fractionExpressionEvaluator = 
                    new SimpleFractionExpressionEvaluator();
                Fraction expResult = fractionExpressionEvaluator.eval(inputArray[1]);
                output = serverMessage(ACCEPTED, expResult.toString());
            } catch (EvaluationExpressionException | FractionArithmeticException e) {
                output = serverMessage(BAD_REQUEST, e.getMessage());
            }
        }
        if (state.equals(HELP)) {
            output = "ACCEPTED COMMANDS: HELP, CALC, QUIT";
        }
        if (state.equals(QUIT)) {
            output = "BYE!";
        }
        return output;
    }
    
    private String[] parseInput(String input) {
        if (input != null)
            return input.split(" ");
        return new String[1];
    }
    
    public boolean isValid(String[] input) {
        return input.length == 2;
    }
    
    private String serverMessage(String code, String msg) {
        return String.format("CODE: %s %s", code, msg);
    }
}
