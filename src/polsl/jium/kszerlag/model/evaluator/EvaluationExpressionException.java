package polsl.jium.kszerlag.model.evaluator;

/**
 * An exception is thrown when it is impossible to evaluate the passed expression.
 * 
 * @version 1.0
 * @author Kamil Szerląg
 */
public class EvaluationExpressionException extends Exception {

    public EvaluationExpressionException(String message) {
        super(message);
    }
    
}
