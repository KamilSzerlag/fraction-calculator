package polsl.jium.kszerlag.controller;

import polsl.jium.kszerlag.model.evaluator.EvaluationExpressionException;
import polsl.jium.kszerlag.model.evaluator.SimpleFractionExpressionEvaluator;
import polsl.jium.kszerlag.view.CalculatorView;

/**
 * Controller class that performs the role of an intermediate layer between 
 * the view an the model.
 * 
 * @version 1.0
 * @author szerlag
 */
public class FractionCalculatorController {
    private SimpleFractionExpressionEvaluator evaluator;
    private CalculatorView calculatorView; 

    public FractionCalculatorController(SimpleFractionExpressionEvaluator evaluator, CalculatorView calculatorView) {
        this.evaluator = evaluator;
        this.calculatorView = calculatorView;
    }
    
    /**
     * Performing expression calculation, and displaying result value in 
     * calculator view text field.
     * 
     * @param expression - <code>String</code> contains mathematics expression.
     * @throws EvaluationExpressionException - when expression can't be evaluated.
     */
    public void calculate(String expression) throws EvaluationExpressionException {
        calculatorView.displayCalculationResult(evaluator.eval(expression));
    }
    
    
}
