package polsl.jium.kszerlag;

import polsl.jium.kszerlag.controller.FractionCalculatorController;
import polsl.jium.kszerlag.model.evaluator.EvaluationExpressionStrategy;
import polsl.jium.kszerlag.model.evaluator.PolishNotationExpressionEvaluator;
import polsl.jium.kszerlag.model.evaluator.SimpleFractionExpressionEvaluator;
import polsl.jium.kszerlag.view.CalculatorView;

/**
 * FractionCalculatorApp helps performing operations on mathematics fraction.
 * Input expression for example like "2/1+3/5" will be calculated 
 * and displayed in calculator window text field.
 * 
 * Actually basic arithmetic operations are supported.
 * 
 * Application using MVC patter for communications between logic and visual layer. 
 *
 * @author szerlag
 * @version 1.0
 */
public class FractionCalculatorApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SimpleFractionExpressionEvaluator evaluator = new SimpleFractionExpressionEvaluator();
        CalculatorView calculatorView = new CalculatorView();
        FractionCalculatorController controller = new FractionCalculatorController(evaluator, calculatorView);
        calculatorView.setController(controller);
        
        PolishNotationExpressionEvaluator evalStrategy = new PolishNotationExpressionEvaluator();
        System.out.println(evalStrategy.toPostifix("3+4*2:(1-5)"));
    }
    
}
