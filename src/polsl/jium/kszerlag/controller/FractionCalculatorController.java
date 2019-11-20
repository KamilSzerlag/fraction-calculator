package polsl.jium.kszerlag.controller;

import polsl.jium.kszerlag.model.arithmetic.fraction.FractionArithmeticException;
import polsl.jium.kszerlag.model.arithmetic.fraction.InvalidFractionFormatException;
import polsl.jium.kszerlag.model.evaluator.EvaluationExpressionException;
import polsl.jium.kszerlag.model.evaluator.SimpleFractionExpressionEvaluator;
import polsl.jium.kszerlag.view.Displayable;

/**
 * Controller class that performs the role of an intermediate layer between 
 * the view an the model.
 * 
 * @version 2.0
 * @author Kamil Szerląg
 */
public class FractionCalculatorController {
    
    private final SimpleFractionExpressionEvaluator evaluator;
    private final Displayable calculatorView; 

    /**
     * Constructing controller with defined model logic provided by 
     * <code>SimpleFractionExpressionEvaluator</code> and view represented by
     * class implementing <code>Displayable</code> interface.
     * 
     * @param evaluator model containing logic to evaluating mathematical expression.
     * @param calculatorView view implementing <code>Displayable</code> interface.
     */
    public FractionCalculatorController(SimpleFractionExpressionEvaluator evaluator, Displayable calculatorView) {
        this.evaluator = evaluator;
        this.calculatorView = calculatorView;
    }
    
    /**
     * Performing expression calculation, and displaying result value in 
     * calculator view text field.
     * 
     * @param expression - <code>String</code> contains mathematics expression containing fractions.
     */
    public void calculate(String expression) {
        try {
            calculatorView.displayCalculationResult(evaluator.eval(expression));
        } catch (FractionArithmeticException | InvalidFractionFormatException e) {
            calculatorView.displayWarningMsg(e);
        } catch (EvaluationExpressionException e) {
            calculatorView.displayErrorMsg(e); 
        } catch (Exception e) {
            calculatorView.displayErrorMsg(e);
        }
    }
    
    
}
