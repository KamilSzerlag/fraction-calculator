package polsl.jium.kszerlag.view.console;

import polsl.jium.kszerlag.model.arithmetic.fraction.Fraction;
import polsl.jium.kszerlag.view.Displayable;

/**
 * This class is printing provided content in console. 
 * 
 * @version 1.0
 * @author Kamil Szerląg
 */
public class ConsolePrinter implements Displayable {

    @Override
    public void displayCalculationResult(Fraction fraction) {
        System.out.println("RESULT:\n" + fraction.toString());
    }

    @Override
    public void displayWarningMsg(RuntimeException e) {
        System.out.println("Warning: " + e.getMessage());
    }

    @Override
    public void displayErrorMsg(Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
    
}
