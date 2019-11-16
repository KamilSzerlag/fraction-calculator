package polsl.jium.kszerlag;

import polsl.jium.kszerlag.controller.FractionCalculatorController;
import polsl.jium.kszerlag.model.evaluator.SimpleFractionExpressionEvaluator;
import polsl.jium.kszerlag.view.console.ConsolePrinter;
import polsl.jium.kszerlag.view.window.CalculatorView;

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
     * @param args expression to evaluation contaning operation on fractions.
     * For example:
     * "1/2+3/4"
     * <b>Note:</b>Running interactive mode if no arguments were passed. 
     */
    public static void main(String[] args) {
        SimpleFractionExpressionEvaluator evaluator = new SimpleFractionExpressionEvaluator();
        if (args.length == 1) {
            ConsolePrinter consolePrinter = new ConsolePrinter();
            FractionCalculatorController controller = new FractionCalculatorController(evaluator, consolePrinter);
            controller.calculate(args[0]);
        } else {
            CalculatorView calculatorView = new CalculatorView();
            FractionCalculatorController controller = new FractionCalculatorController(evaluator, calculatorView);
            calculatorView.setController(controller);
        }
    }
    
}
